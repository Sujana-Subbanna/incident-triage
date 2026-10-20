package io.github.sujanasubbanna.incidenttriage.incident;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

import static io.github.sujanasubbanna.incidenttriage.common.KafkaConstants.INCIDENT_CREATED_TOPIC;

@Service
public class IncidentService {


    private static final Logger log = LoggerFactory.getLogger(IncidentService.class);
    private final IncidentRepository incidentRepository;
    private final KafkaTemplate<String, IncidentCreatedEvent> kafkaIncidentCreatedTemplate;

    @Autowired
    IncidentService(IncidentRepository incidentRepository, KafkaTemplate<String, IncidentCreatedEvent> kafkaIncidentCreatedTemplate){
        this.incidentRepository = incidentRepository;
        this.kafkaIncidentCreatedTemplate = kafkaIncidentCreatedTemplate;
    }

    private String generateNumber(){
        return String.format("INC%010d", incidentRepository.nextIncidentNumber());
    }

    public IncidentResponse createIncident(CreateIncidentRequest createIncidentRequest){

        IncidentPriority incidentPriority = getIncidentPriority(createIncidentRequest.affectedCis());
        Incident incident = new Incident(generateNumber(), createIncidentRequest.shortDescription(), createIncidentRequest.description(),
                createIncidentRequest.errorCode(), createIncidentRequest.suspectedCi(), createIncidentRequest.affectedCis(), IncidentStatus.NEW, incidentPriority,
                createIncidentRequest.createdBy(), Instant.now(), null);

        incidentRepository.save(incident);
        log.debug("Successfully saved the incident number {} ", incident.getNumber());
        IncidentCreatedEvent createdEvent = new IncidentCreatedEvent(incident.getNumber(), incident.getCreatedAt());
        kafkaIncidentCreatedTemplate.send(INCIDENT_CREATED_TOPIC, incident.getNumber(), createdEvent);

        return IncidentResponse.from(incident);

    }

    private static IncidentPriority getIncidentPriority(List<String> affectedCis) {
        boolean isProdCi = affectedCis.stream().anyMatch(ci -> ci.toLowerCase().contains("prod") || ci.toLowerCase().contains("prd"));
        return isProdCi ? IncidentPriority.HIGH : IncidentPriority.LOW;
    }

}
