package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.HotelRequest;
import com.example.backendfor3semester.dto.HotelResponse;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelService {
    private final HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public int getNumberOfRooms(Integer hotelId) {
        return hotelRepository.countRoomsByHotelId(hotelId);
    } public Hotel createHotel(HotelRequest hotelRequest) {
        Hotel hotel = hotelRequest.hotelBuilder();
        return hotelRepository.save(hotel);
    }
    public List<HotelResponse> getAllHotelResponses() {
        List<Hotel> hotels = hotelRepository.findAll();
        List<HotelResponse> hotelResponses = new ArrayList<>();

        for (Hotel hotel : hotels) {
            HotelResponse response = new HotelResponse();
            response.setId(hotel.getId());
            response.setName(hotel.getName());
            response.setStreet(hotel.getStreet());
            response.setCity(hotel.getCity());
            response.setZip(hotel.getZip());
            response.setCountry(hotel.getCountry());
            response.setNumberOfRooms(getNumberOfRooms(hotel.getId()));

            hotelResponses.add(response);
        }

        return hotelResponses;
    }

    public HotelResponse getHotelResponseById(Integer id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);

        if (hotel != null) {
            HotelResponse response = new HotelResponse();
            response.setId(hotel.getId());
            response.setName(hotel.getName());
            response.setStreet(hotel.getStreet());
            response.setCity(hotel.getCity());
            response.setZip(hotel.getZip());
            response.setCountry(hotel.getCountry());
            response.setNumberOfRooms(getNumberOfRooms(hotel.getId()));

            return response;
        } else {
            return null;
        }
    }
    public Hotel getHotelById(Integer id){
        Hotel hotel = hotelRepository.findById(id).orElse(null);

        return hotel;
    }
    public void deleteHotelById(Integer id) {
        hotelRepository.deleteById(id);
    }
    public Hotel updateHotel(Integer id, HotelRequest hotelRequest) {
        Hotel existingHotel = hotelRepository.findById(id).orElse(null);

        if (existingHotel != null) {
            // Update the existing hotel with the new data
            existingHotel.setName(hotelRequest.getName());
            existingHotel.setStreet(hotelRequest.getStreet());
            existingHotel.setCity(hotelRequest.getCity());
            existingHotel.setZip(hotelRequest.getZip());
            existingHotel.setCountry(hotelRequest.getCountry());

            // Save and return the updated hotel
            return hotelRepository.save(existingHotel);
        }

        return null; // Hotel with the specified id not found
    }

    public List<Hotel> findHotelsByType(String hotelType) {
        return hotelRepository.findByHotelType(hotelType);
    }




}
