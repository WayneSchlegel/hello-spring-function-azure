package com.example.model;

import java.util.HashSet;
import java.util.Set;

public class TestResult {

    private final Set<Complaint> complaints = new HashSet<>();

    public Set<Complaint> getComplaints() {
        return complaints;
    }

    public void addComplaint(Complaint complaint) {
        complaints.add(complaint);
    }
}
