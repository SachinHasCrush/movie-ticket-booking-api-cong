package com.example.mtb.exceptions.handler;

import lombok.Getter;

@Getter
public class UserNotFoundByEmailException extends RuntimeException {

    private final String message;

    public UserNotFoundByEmailException(String message) {
        this.message = message;
    }
}
