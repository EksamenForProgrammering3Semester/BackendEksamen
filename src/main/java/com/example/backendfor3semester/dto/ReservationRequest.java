package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.entity.Reservation;
import com.example.backendfor3semester.entity.Room;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationRequest {

    private int room;
    private int guest;
    private LocalDateTime reservationDate;
    public Reservation reservationBuilder(){

        return Reservation
                .builder()
                .reservationDate(reservationDate)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now()).build();
    }
}
