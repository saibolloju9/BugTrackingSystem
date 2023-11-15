package com.project.bugtrackingsystem.exception;

// Custom exception class for handling project-related exceptions
public class ProjectException extends RuntimeException {

    // Constructor with a message to provide additional details about the exception
    public ProjectException(String message) {
        super(message);
    }
}
