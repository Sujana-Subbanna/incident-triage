package io.github.sujanasubbanna.incidenttriage.incident;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import java.time.Instant;
import java.util.List;

@Entity
public class Incident {

    @Id
    @GeneratedValue()
    private Long id;

    @Column(length = 13, nullable = false, unique = true)
    private String number;

    @Column(length = 200, nullable = false)
    private String shortDescription;

    @Column(length = 1500)
    private String description;

    @Column(length = 50)
    private String errorCode;

    @Column(length = 100)
    private String suspectedCi;

    @ElementCollection
    @CollectionTable(name = "AFFECTED_CIS", joinColumns = @JoinColumn(name = "incident_id"))
    @Column(name = "AFFECTED_CIS", length = 100, nullable = false)
    private List<String> affectedCis;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentStatus status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private IncidentPriority priority;

    @Column(length = 100, nullable = false)
    private String createdBy;

    @Column(nullable = false)
    private Instant createdAt;

    @Column(length = 100)
    private String assignmentGroup;

    @Column(length = 100)
    private String assignedTo;

    @Column(length = 1500)
    private String resolutionNotes;

    private Instant resolvedAt;

    public Long getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getDescription() {
        return description;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getSuspectedCi() {
        return suspectedCi;
    }

    public List<String> getAffectedCis() {
        return affectedCis;
    }

    public IncidentStatus getStatus() {
        return status;
    }

    public IncidentPriority getPriority() {
        return priority;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public String getAssignmentGroup() {
        return assignmentGroup;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public String getResolutionNotes() {
        return resolutionNotes;
    }

    public Instant getResolvedAt() {
        return resolvedAt;
    }

    public void setSuspectedCi(String suspectedCi) {
        this.suspectedCi = suspectedCi;
    }

    public void setAffectedCis(List<String> affectedCis) {
        this.affectedCis = affectedCis;
    }

    public void setStatus(IncidentStatus status) {
        this.status = status;
    }

    public void setAssignmentGroup(String assignmentGroup) {
        this.assignmentGroup = assignmentGroup;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setResolutionNotes(String resolutionNotes) {
        this.resolutionNotes = resolutionNotes;
    }

    public void setResolvedAt(Instant resolvedAt) {
        this.resolvedAt = resolvedAt;
    }

    protected Incident() {

    }

    public Incident(String number, String shortDescription, String description, String errorCode, String suspectedCi, List<String> affectedCis,
                    IncidentStatus status, IncidentPriority priority, String createdBy, Instant createdAt, String assignmentGroup){
        this.number = number;
        this.shortDescription = shortDescription;
        this.description = description;
        this.errorCode = errorCode;
        this.suspectedCi = suspectedCi;
        this.affectedCis = affectedCis;
        this.status = status;
        this.priority = priority;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.assignmentGroup = assignmentGroup;
    }

}
