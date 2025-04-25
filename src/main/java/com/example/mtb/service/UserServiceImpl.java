package com.example.mtb.service;

import com.example.mtb.entity.TheaterOwner;
import com.example.mtb.entity.User;
import com.example.mtb.entity.UserDetails;
import com.example.mtb.exceptions.UserExistByEmailException;
import com.example.mtb.repository.UserRepository;
import com.example.mtb.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public UserDetails addUser(UserDetails user) {
        if(! userRepository.existsByEmail(user.getEmail())){
//            return copy(user);
            switch (user.getUserRole()){
                case USER -> copy(new User(), user);
                case THEATER_OWNER -> copy(new TheaterOwner(), user);
            }
        }
        throw new UserExistByEmailException("User with the Email is already exists");
    }

    private UserDetails copy(UserDetails userRole, UserDetails user){
//        UserDetails userRole = user.getUserRole()==UserRole.USER ? new User() : new TheaterOwner();
        userRole.setUserRole(user.getUserRole());
        userRole.setEmail(user.getEmail());
        userRole.setPassword(user.getPassword());
        userRole.setCreatedAt(user.getCreatedAt());
        userRole.setDateOfBirth(user.getDateOfBirth());
        userRole.setPhoneNumber(user.getPhoneNumber());
        userRole.setUsername(user.getUsername());
        userRole.setUpdatedAt(user.getUpdatedAt());
        userRepository.save(userRole);
        return userRole;
    }
}
