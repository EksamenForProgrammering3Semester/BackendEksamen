package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Hotel;
import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelRequest {
    private String name;
    private String street;
    private String city;
    private String zip;
    private String country;

    public Hotel hotelBuilder() {
        return Hotel.builder()
                .name(name)
                .street(street)
                .city(city)
                .zip(zip)
                .country(country)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }
}
