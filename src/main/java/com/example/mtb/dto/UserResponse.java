package com.example.mtb.dto;

import com.example.mtb.enums.UserRole;
import lombok.Builder;


@Builder
public record UserResponse(
        String userId,
        String username,
        String email,
        String phoneNumber,
        UserRole userRole

){}
