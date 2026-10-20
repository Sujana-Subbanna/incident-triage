package io.github.sujanasubbanna.incidenttriage.incident;

import java.time.Instant;

public record IncidentCreatedEvent(
        String incidentNumber,
        Instant occurredAt)
{}