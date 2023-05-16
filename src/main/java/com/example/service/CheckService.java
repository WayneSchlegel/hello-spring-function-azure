package com.example.service;

import com.example.model.Complaint;
import com.example.model.ComplaintParameter;
import com.example.model.TestInput;
import com.example.model.TestResult;
import org.springframework.stereotype.Service;

@Service
public class CheckService {
    public TestResult check(TestInput testInput) {
        final var result = new TestResult();
        final var dummyComplaint = new Complaint();
        dummyComplaint.setDescription("Dummy-Fehler");
        final var dummyComplaintParameter = new ComplaintParameter("dummy-key", testInput.getTestAttribute());
        dummyComplaint.addComplaintParameter(dummyComplaintParameter);
        dummyComplaint.setCheckId("dummy-Check");
        dummyComplaint.setReferenceId("dummy-referenceId");
        result.addComplaint(dummyComplaint);
        return result;
    }
}
