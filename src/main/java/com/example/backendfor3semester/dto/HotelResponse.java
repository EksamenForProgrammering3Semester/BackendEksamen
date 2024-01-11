package com.example.backendfor3semester.dto;

import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.service.HotelService;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponse {


    private Integer id;
    private String name;
    private String street;
    private String city;
    private String zip;
    private String country;
    private int numberOfRooms;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private HotelService hotelService;

    public HotelResponse(Hotel hotel) {

        this.id = hotel.getId();
        this.name = hotel.getName();
        this.street = hotel.getStreet();
        this.city = hotel.getCity();
        this.zip = hotel.getZip();
        this.country = hotel.getCountry();
        this.numberOfRooms = hotelService.getNumberOfRooms(hotel.getId());
    }
}
