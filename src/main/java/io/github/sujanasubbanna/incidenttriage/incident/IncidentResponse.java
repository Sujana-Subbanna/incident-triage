package io.github.sujanasubbanna.incidenttriage.incident;

import java.time.Instant;
import java.util.List;

public record IncidentResponse(
        String number,
        String shortDescription,
        String description,
        String errorCode,
        String suspectedCi,
        List<String> affectedCis,
        IncidentStatus status,
        IncidentPriority priority,
        String createdBy,
        Instant createdAt,
        String assignmentGroup,
        String assignedTo)
{
    public static IncidentResponse from(Incident incident){
        return new IncidentResponse(incident.getNumber(), incident.getShortDescription(), incident.getDescription(), incident.getErrorCode(),
                incident.getSuspectedCi(), incident.getAffectedCis(), incident.getStatus(), incident.getPriority(), incident.getCreatedBy(), incident.getCreatedAt(),
                incident.getAssignmentGroup(), incident.getAssignedTo());
    }
}
