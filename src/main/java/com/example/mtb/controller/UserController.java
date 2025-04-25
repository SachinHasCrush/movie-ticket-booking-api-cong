package com.example.mtb.controller;
import com.example.mtb.dto.UserRegistrationRequest;
import com.example.mtb.dto.UserResponse;
import com.example.mtb.dto.UserUpdationRequest;
import com.example.mtb.service.UserService;
import com.example.mtb.util.ResponseStructure;
import com.example.mtb.util.RestResponseBuilder;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final RestResponseBuilder responseBuilder;

    @PostMapping("/register")
    public ResponseEntity<ResponseStructure<UserResponse>> addUser(@RequestBody @Valid UserRegistrationRequest user){
        UserResponse userDetails = userService.addUser(user);
        return responseBuilder.sucess(HttpStatus.OK,"New User Details Has been added", userDetails);
    }

    @PutMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> editUser(@PathVariable String email, @RequestBody @Valid UserUpdationRequest user){
        UserResponse userDetails = userService.editUser(user, email);
        return responseBuilder.sucess(HttpStatus.OK,"User Details has been updated", userDetails);
    }

    @DeleteMapping("/users/{email}")
    public ResponseEntity<ResponseStructure<UserResponse>> softDeleteUser(@PathVariable String email){
        UserResponse userDetails = userService.softDeleteUser(email);
        return responseBuilder.sucess(HttpStatus.OK,"UserDetails account has been deleted ", userDetails);
    }
}


