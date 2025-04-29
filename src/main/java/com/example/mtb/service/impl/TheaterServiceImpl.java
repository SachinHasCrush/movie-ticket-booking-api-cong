package com.example.mtb.service.impl;

import com.example.mtb.dto.TheaterRequest;
import com.example.mtb.dto.TheaterResponse;
import com.example.mtb.entity.Theater;
import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.enums.UserRole;
import com.example.mtb.mapper.TheaterMapper;
import com.example.mtb.repository.TheaterRepository;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.TheaterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TheaterServiceImpl implements TheaterService {

    private final TheaterRepository theaterRepository;
    private final TheaterMapper theaterMapper;
    private final UserRepository userRepository;

    @Override
    public TheaterResponse addTheater(String email, TheaterRequest theaterRequest) {

        if (userRepository.existsByEmail(email) && userRepository.findByEmail(email).getUserRole() == UserRole.THEATER_OWNER) {
            UserDetails user = userRepository.findByEmail(email);
            Theater theater = copy(theaterRequest, new Theater(), user);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new com.example.mtb.exceptions.handler.UserNotFoundByEmailException("No Theater Owner with the provided email is present");
    }

    @Override
    public TheaterResponse findTheater(String theaterId) {
        if(theaterRepository.existsById(theaterId)){
            Theater theater = theaterRepository.findById(theaterId).get();
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new com.example.mtb.exceptions.handler.UserNotFoundByEmailException("Theater not found by the id");
    }

    @Override
    public TheaterResponse updateTheater(String theaterId, TheaterRequest registerationRequest) {
        if(theaterRepository.existsById(theaterId)) {
            Theater theater = theaterRepository.findById(theaterId).get();
            theater = copy(registerationRequest, theater);
            return theaterMapper.theaterResponseMapper(theater);
        }
        throw new com.example.mtb.exceptions.handler.TheaterNotFoundByIdException("Theater not found by id");
    }




    private Theater copy(TheaterRequest registerationRequest, Theater theater, UserDetails userDetails) {
        theater.setAddress(registerationRequest.address());
        theater.setCity(registerationRequest.city());
        theater.setName(registerationRequest.name());
        theater.setLandmark(registerationRequest.landmark());
        theater.setTheaterOwner((TheaterOwner) userDetails);
        theaterRepository.save(theater);
        return theater;
    }

    private Theater copy(TheaterRequest registerationRequest, Theater theater) {
        theater.setAddress(registerationRequest.address());
        theater.setCity(registerationRequest.city());
        theater.setName(registerationRequest.name());
        theater.setLandmark(registerationRequest.landmark());
        theaterRepository.save(theater);
        return theater;
    }
}