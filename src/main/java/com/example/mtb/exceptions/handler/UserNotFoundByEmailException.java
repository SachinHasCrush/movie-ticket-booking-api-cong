package com.example.mtb.exceptions.handler;


public class UserNotFoundByEmailException extends RuntimeException {
    public UserNotFoundByEmailException(String message) {
        super(message);
    }
}

