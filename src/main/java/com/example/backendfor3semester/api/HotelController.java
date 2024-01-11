package com.example.backendfor3semester.api;

import com.example.backendfor3semester.dto.HotelRequest;
import com.example.backendfor3semester.dto.HotelResponse;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
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
    @GetMapping("/all")
    public ResponseEntity<List<HotelResponse>> getAllHotels() {
        List<HotelResponse> hotelResponses = hotelService.getAllHotelResponses();
        return new ResponseEntity<>(hotelResponses, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public HotelResponse getHotelById(@PathVariable Integer id) {
        return hotelService.getHotelResponseById(id);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotelById(@PathVariable Integer id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Integer id, @RequestBody HotelRequest hotelRequest) {
        Hotel updatedHotel = hotelService.updateHotel(id, hotelRequest);

        if (updatedHotel != null) {
            return ResponseEntity.ok(updatedHotel);
        } else {
            return ResponseEntity.notFound().build();
        }


    }