package com.example.mtb.exceptions;

import lombok.Getter;

@Getter
public class ScreenNotFoundByIdException extends RuntimeException {

    private String message;

    public ScreenNotFoundByIdException(String message) {
        this.message = message;
    }
}
