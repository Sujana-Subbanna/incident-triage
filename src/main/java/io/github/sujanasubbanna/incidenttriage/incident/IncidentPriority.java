package io.github.sujanasubbanna.incidenttriage.incident;

import java.util.Arrays;

public enum IncidentPriority {
    CRITICAL(1),
    HIGH(2),
    MODERATE(3),
    LOW(4),
    PLANNING(5);

    private final int code;

    IncidentPriority(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static IncidentPriority fromCode(int code){
        return Arrays.stream(values())
                .filter(p -> p.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown incident priority code: " + code));

    }
}
