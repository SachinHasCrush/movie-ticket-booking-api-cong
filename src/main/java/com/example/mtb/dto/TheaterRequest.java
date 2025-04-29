package com.example.mtb.dto;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record TheaterRequest(

        @NotNull(message = "Name is required")
        @Size(min = 1, max = 20, message = "Name cannot be blank")
        String name,

        @NotNull(message = "Address is required")
        @Size(min = 1, max = 50, message = "Address cannot be blank")
        String address,

        @NotNull(message = "City is required")
        @Size(min = 1, max = 20, message = "City cannot be blank")
        String city,

        @NotNull(message = "Landmark is required")
        @Size(min = 1, max = 20, message = "Landmark cannot be blank")
        String landmark
)
{}