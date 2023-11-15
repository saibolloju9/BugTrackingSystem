package com.project.bugtrackingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom exception class for handling bugs-related exceptions
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BugException extends RuntimeException {

    // Constructor with a message to provide additional details about the exception
    public BugException(String message) {
        super(message);
    }
}