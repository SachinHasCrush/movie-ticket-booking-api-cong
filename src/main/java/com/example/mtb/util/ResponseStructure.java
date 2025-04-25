package com.example.mtb.util;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Builder
public class ResponseStructure<T> {
    private int StatusCode;
    private String message;
    private T data;
}
