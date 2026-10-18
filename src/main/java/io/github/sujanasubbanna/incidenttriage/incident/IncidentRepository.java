package io.github.sujanasubbanna.incidenttriage.incident;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface IncidentRepository extends JpaRepository<Incident, Long> {

    Optional<Incident> findByNumber(String number);

    @Query(value = "SELECT NEXT VALUE FOR incident_number_seq", nativeQuery = true)
    Long nextIncidentNumber();

}
