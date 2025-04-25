package com.example.mtb.entity;

import com.example.mtb.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Setter
@Getter
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String userId;
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    private String phoneNumber;
    @Enumerated(value = EnumType.STRING)
    private UserRole userRole;
    private LocalDate dateOfBirth;
    private long createdAt;
    private long updatedAt;
}
