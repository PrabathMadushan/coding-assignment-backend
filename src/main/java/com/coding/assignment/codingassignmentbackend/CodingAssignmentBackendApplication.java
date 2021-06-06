package com.coding.assignment.codingassignmentbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
public class CodingAssignmentBackendApplication extends SpringBootServletInitializer {

    private static final Class<CodingAssignmentBackendApplication> applicationClass = CodingAssignmentBackendApplication.class;
    public static void main(String[] args) {
        SpringApplication.run(CodingAssignmentBackendApplication.class, args);
    }

    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }

}
