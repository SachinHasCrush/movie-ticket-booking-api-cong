package com.example.mtb.service.impl;

import com.example.mtb.dto.ScreenRequest;
import com.example.mtb.dto.ScreenResponse;
import com.example.mtb.entity.Screen;
import com.example.mtb.entity.Seat;
import com.example.mtb.entity.Theater;
import com.example.mtb.exceptions.handler.TheaterNotFoundByIdException;
import com.example.mtb.mapper.ScreenMapper;
import com.example.mtb.repository.ScreenRepository;
import com.example.mtb.repository.SeatRepository;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.service.ScreenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class ScreenServiceImpl implements ScreenService {

    private final TheaterRepository theaterRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;
    private final ScreenMapper screenMapper;

    @Override
    public ScreenResponse addScreen(ScreenRequest screenRequest, String theaterId) {

        if(theaterRepository.existsById(theaterId)){
            Theater theater = theaterRepository.findById(theaterId).get();
            Screen screen = copy(screenRequest, new Screen(), theater);
            return screenMapper.screenResponseMapper(screen);
        }

        throw new com.example.mtb.exceptions.handler.TheaterNotFoundByIdException("No Theater found by ID");

    }

    @Override
    public ScreenResponse findScreen(String theaterId, String screenId) {
        return null;
    }

    private Screen copy(ScreenRequest screenRequest, Screen screen, Theater theater){
        screen.setScreenType(screenRequest.screenType());
        screen.setCapacity(screenRequest.capacity());
        screen.setNoOfRows(screenRequest.noOfRows());
        screen.setTheater(theater);
        screenRepository.save(screen);
        screen.setSeats(createSeats(screen, screenRequest.capacity() ));
        return screen;
    }

    private List<Seat> createSeats (Screen screen, Integer capacity){
        List<Seat> seats = new LinkedList<>();
        for (int i = 1; i<= capacity; i++){
            Seat seat = new Seat();
            seat.setScreen(screen);
            seatRepository.save(seat);
            seats.add(seat);
        }
        return seats;
    }

}
