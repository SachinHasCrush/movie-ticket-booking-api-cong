package com.example.mtb.exceptions;

import lombok.Getter;

@Getter
public class NoOfRowsExceedCapacityException extends RuntimeException {

    private String message;

    public NoOfRowsExceedCapacityException(String message) {
        this.message = message;
    }
}