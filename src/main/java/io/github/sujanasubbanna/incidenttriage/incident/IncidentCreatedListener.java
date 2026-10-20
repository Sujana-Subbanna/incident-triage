package io.github.sujanasubbanna.incidenttriage.incident;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static io.github.sujanasubbanna.incidenttriage.common.KafkaConstants.INCIDENT_CREATED_TOPIC;

@Component
public class IncidentCreatedListener {

    private static final Logger log = LoggerFactory.getLogger(IncidentCreatedListener.class);

    @KafkaListener(topics = INCIDENT_CREATED_TOPIC)
    public void onIncidentCreated(IncidentCreatedEvent incidentCreatedEvent){
        log.debug("Received incident with incident number {} at {}" , incidentCreatedEvent.incidentNumber(),
                incidentCreatedEvent.occurredAt());
    }


}
