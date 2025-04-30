package com.example.mtb.mapper;

import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.entity.Screen;
import org.springframework.stereotype.Component;

@Component
public class ScreenMapper {

    public ScreenResponse screenResponseMapper(Screen screen) {
        if (screen == null)
            return null;
        return new ScreenResponse(
                screen.getScreenId(),
                screen.getScreenType(),
                screen.getCapacity(),
                screen.getNoOfRows()

        );
    }
}