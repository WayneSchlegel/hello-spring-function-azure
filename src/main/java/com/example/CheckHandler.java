package com.example;

import com.example.model.TestInput;
import com.example.model.TestResult;
import com.microsoft.azure.functions.*;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import java.util.Optional;

public class CheckHandler extends FunctionInvoker<TestInput, TestResult> {

    @FunctionName("check")
    public HttpResponseMessage execute(
            @HttpTrigger(name = "request", methods = {HttpMethod.GET, HttpMethod.POST}, authLevel = AuthorizationLevel.ANONYMOUS)
            HttpRequestMessage<Optional<TestInput>> request,
            ExecutionContext context) {
        TestInput testInput = request.getBody()
                .filter((u -> u.getName() != null))
                .orElseGet(() -> new TestInput(
                        request.getQueryParameters()
                                .getOrDefault("name", "world")));
        context.getLogger().info("TestInput name: " + testInput.getName());
        return request
                .createResponseBuilder(HttpStatus.OK)
                .body(handleRequest(testInput, context))
                .header("Content-Type", "application/json")
                .build();
    }
}
