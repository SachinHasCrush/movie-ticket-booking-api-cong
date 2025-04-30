package com.example.mtb.dto;


import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record SeatRespose (
        String seatId,
        String name
)
{}
