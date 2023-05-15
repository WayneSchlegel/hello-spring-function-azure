package com.example.model;

import java.util.HashSet;
import java.util.Set;

public class Complaint {
    private final Set<ComplaintParameter> complaintParameters = new HashSet<>();
    private String referenceId;
    private String checkId;
    private String description;
    private Severity severity;

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Severity getSeverity() {
        return severity;
    }

    public void setSeverity(Severity severity) {
        this.severity = severity;
    }

    public Set<ComplaintParameter> getComplaintParameters() {
        return complaintParameters;
    }

    public void addComplaintParameter(ComplaintParameter complaintParameter) {
        this.complaintParameters.add(complaintParameter);
    }
}
