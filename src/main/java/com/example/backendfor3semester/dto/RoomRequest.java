package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequest {


    private Integer id;
    private String roomNumber;
    private int numberOfBeds;

    private Hotel hotel;


    public Room roomBuilder(){
        return Room.builder()
                .roomNumber(roomNumber)
                .numberOfBeds(numberOfBeds)
                .hotel(hotel)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }
}
