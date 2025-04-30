package com.example.mtb.dto;


import com.example.mtb.enums.ScreenType;
import lombok.Builder;

@Builder
public record ScreenResponse(

        String screenId,
        ScreenType screenType,
        Integer capacity,
        Integer noOfRows

)
{}