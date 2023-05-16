package com.example.config;

import com.example.model.TestInput;
import com.example.model.TestResult;
import com.example.service.CheckService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class FunctionConfig {
    @Bean
    public Function<Mono<TestInput>, Mono<TestResult>> check(final CheckService checkService) {
        return mono -> mono.map(checkService::check);
    }
}
