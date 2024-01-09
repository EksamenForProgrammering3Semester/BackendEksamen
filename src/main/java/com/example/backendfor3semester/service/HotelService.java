package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.HotelRequest;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public int getNumberOfRooms(Integer hotelId) {
        return hotelRepository.countRoomsByHotelId(hotelId);
    }
    public Hotel createHotel(HotelRequest hotelRequest) {
        Hotel hotel = hotelRequest.hotelBuilder();
        return hotelRepository.save(hotel);
    }
}
