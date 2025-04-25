package com.example.mtb.util;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class FieldErrorStructure<T> {
    private int statusCode;
    @JsonProperty(namespace = "error_message")
    private String errorMessage;
    T data;
}