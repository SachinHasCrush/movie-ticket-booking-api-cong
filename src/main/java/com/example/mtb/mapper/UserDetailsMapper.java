package com.example.mtb.mapper;

import com.example.mtb.dto.UserResponse;
import com.example.mtb.entity.UserDetails;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsMapper {


    public UserResponse userDetailsResponseMapper(UserDetails userDetails){
        if(userDetails == null)
            return null;
        return new UserResponse(
                userDetails.getUserId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                userDetails.getPhoneNumber(),
                userDetails.getUserRole()
        );
    }

}
