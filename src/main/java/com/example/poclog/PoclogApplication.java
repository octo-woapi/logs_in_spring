package com.example.poclog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import java.util.function.Predicate;

@SpringBootApplication
public class PoclogApplication {

    @Bean
    public CommonsRequestLoggingFilter logFilter() {
        CommonsRequestLoggingFilter filter
                = new CommonsRequestLoggingFilter();
        filter.setIncludeQueryString(true);
        filter.setIncludePayload(true);
        filter.setMaxPayloadLength(10000);
        filter.setIncludeHeaders(true);
        filter.setHeaderPredicate(s -> s.equals("user-agent"));
        filter.setAfterMessagePrefix("REQUEST DATA : ");
        return filter;
    }

    public static void main(String[] args) {
        SpringApplication.run(PoclogApplication.class, args);
    }
}
