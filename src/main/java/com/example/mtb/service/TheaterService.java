package com.example.mtb.service;


import com.example.mtb.dto.*;
import jakarta.validation.Valid;

public interface TheaterService {

    TheaterResponse addTheater(String email, TheaterRequest theaterRequest);

    TheaterResponse findTheater(String theaterId);

    TheaterResponse updateTheater(String theaterId, TheaterRequest registerationRequest);

//    public class userService {
//        public UserResponse addUser(@Valid UserRegistrationRequest user) {
//
//            return null;
//        }
//
//        public UserResponse editUser(@Valid UserUpdationRequest user, String email) {
//            return null;
//        }
//
//        public UserResponse softDeleteUser(String email) {
//            return null;
//        }
//    }
}
