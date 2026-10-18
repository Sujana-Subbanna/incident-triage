package io.github.sujanasubbanna.incidenttriage.incident;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.util.List;

public record CreateIncidentRequest(
        @NotBlank @Size(max = 200) String shortDescription,

        @Size(max = 1500) String description,

        @Size(max = 50) String errorCode,

        @Size(max = 100) String suspectedCi,

        @NotEmpty List<@Size(max = 100) String> affectedCis,

        @NotBlank @Email @Size(max = 100) String createdBy)
{}
