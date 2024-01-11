package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Guest;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class GuestRequest {

    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;


    public Guest guestBuilder(){
        return Guest.builder().
                username(username).
                password(password).
                firstName(firstName).
                lastName(lastName).
                email(email).
                phoneNumber(phoneNumber).
                created(LocalDateTime.now()).
                updated(LocalDateTime.now()).
                role("guest").build();
    }
}
