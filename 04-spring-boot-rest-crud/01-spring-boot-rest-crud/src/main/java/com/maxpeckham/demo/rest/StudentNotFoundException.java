package com.maxpeckham.demo.rest;

public class StudentNotFoundException extends RuntimeException {
    public StudentNotFoundException(String error) {
        super(error);
    }

    public StudentNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StudentNotFoundException(Throwable cause) {
        super(cause);
    }
}
