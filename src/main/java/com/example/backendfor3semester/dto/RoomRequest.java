package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.service.HotelService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomRequest {


    private String roomNumber;
    private int numberOfBeds;

    private int hotelId;

    public Room roomBuilder() {

        return Room.builder()
                .roomNumber(roomNumber)
                .numberOfBeds(numberOfBeds)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }
}
