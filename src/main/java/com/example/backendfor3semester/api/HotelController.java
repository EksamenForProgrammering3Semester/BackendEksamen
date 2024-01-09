package com.example.backendfor3semester.api;

import com.example.backendfor3semester.dto.HotelRequest;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @PostMapping("/create")
    public ResponseEntity<Hotel> createHotel(@RequestBody HotelRequest hotelRequest) {
        Hotel createdHotel = hotelService.createHotel(hotelRequest);
        return ResponseEntity.ok(createdHotel);
    }
}