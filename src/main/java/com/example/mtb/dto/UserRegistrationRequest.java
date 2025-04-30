package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record UserRegistrationRequest(

        @NotNull
        @Pattern(regexp = "^(?=.{3,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z][a-zA-Z0-9._]*[a-zA-Z0-9]$",
                message = "Username should be minimum of 3 and maximum of 20 alpha-numeric character and can have special characters . and _")
        String username,

        @NotNull
        @Email(message = "Invalid Email format")
        String email,

        @NotNull
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!]).{8,20}$",
                message = "Password should be minimum of 8 characters and should have atleast one uppercase and lowercase alphabet, atleast one special character")
        String password,

        @NotNull
        @Pattern(regexp = "[6-9]\\d{9}$",
                message = "Phone number must be a valid 10-digit Indian number starting with 6–9.")
        String phoneNumber,

        @NotNull
        UserRole userRole,

        @NotNull
        @Past(message = "Date of birth must be a past date")
        LocalDate dateOfBirth


) {
}
