package com.project.bugtrackingsystem;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BugtrackingsystemApplication {

    public static void main(String[] args) {
        // Start the Spring Boot application
        SpringApplication.run(BugtrackingsystemApplication.class, args);
        // Print a message indicating that the Bug Tracking Application has started
        System.out.println("The Bug Tracking Application is Started now.");
    }

    // Create a ModelMapper bean to facilitate object mapping
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
