package com.example.mtb.service;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;

public interface ScreenService {

    ScreenResponse addScreen(ScreenRequest screenRequest, String theaterId);

    ScreenResponse findScreen(String theaterId, String screenId);
}