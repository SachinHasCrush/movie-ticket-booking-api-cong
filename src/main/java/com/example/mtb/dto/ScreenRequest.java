package com.example.mtb.dto;

import com.example.mtb.enums.ScreenType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record ScreenRequest(

        @NotNull(message = "Screen type is required")
        ScreenType screenType,

        @NotNull(message = "Capacity is required")
        @Min(value = 1, message = "Capacity must be at least 1")
        Integer capacity,

        @NotNull(message = "Number of rows is required")
        @Min(value = 1, message = "Number of rows must be at least 1")
        Integer noOfRows

) {}
