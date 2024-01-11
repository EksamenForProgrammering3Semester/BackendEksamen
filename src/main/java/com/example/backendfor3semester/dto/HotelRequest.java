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

        int randomCode = (int) (Math.random() * 3) + 1; // Generates a random number between 1 and 3

        String hotelType;
        switch (randomCode) {
            case 1:
                hotelType = "Family House";
                break;
            case 2:
                hotelType = "Ocean View";
                break;
            case 3:
                hotelType = "Near the City";
                break;
            default:
                hotelType = "Unknown";
        }

        return Hotel.builder()
                .name(name)
                .street(street)
                .city(city)
                .zip(zip)
                .hotelType(hotelType)
                .country(country)
                .created(LocalDateTime.now())
                .updated(LocalDateTime.now())
                .build();
    }
}
