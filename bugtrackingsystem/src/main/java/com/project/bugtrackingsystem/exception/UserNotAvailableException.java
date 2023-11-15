package com.project.bugtrackingsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Custom exception class for signaling that a user is not available
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotAvailableException extends RuntimeException {

    // Constructor with a message to provide additional details about the exception
    public UserNotAvailableException(String message) {
        super(message);
    }
}