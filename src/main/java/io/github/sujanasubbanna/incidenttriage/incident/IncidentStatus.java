package io.github.sujanasubbanna.incidenttriage.incident;

import java.util.Arrays;

public enum IncidentStatus {

    NEW(1),
    IN_PROGRESS(2),
    ON_HOLD(3),
    RESOLVED(6),
    CLOSED(7),
    CANCELLED(8);

    private final int code;

    IncidentStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static IncidentStatus fromCode(int code){
        return Arrays.stream(values())
                .filter(s -> s.getCode() == code)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown incident status code: " + code));
    }
}
