package com.example.backendfor3semester.config;

import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.HotelRepository;
import com.example.backendfor3semester.repository.RoomRepository;
import com.example.backendfor3semester.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Configuration
public class TestData implements CommandLineRunner {

    @Autowired
    private final HotelService hotelService;
    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;
    private final Random random = new Random();

    public TestData(HotelRepository hotelRepository, RoomRepository roomRepository, HotelService hotelService) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
        this.hotelService = hotelService;
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 250; i++) {
            Hotel hotel = new Hotel();
            hotel.setName("Hotel " + i);
            hotel.setStreet("Dummy street " + i);
            hotel.setCity("Dummy city");
            hotel.setZip("12345");
            hotel.setCountry("Dummyland");
            hotel.setCreated(LocalDateTime.now()); // Set created field
            hotel.setUpdated(LocalDateTime.now()); // Set updated field
           // hotelRepository.save(hotel);

            int numberOfRooms = 10 + random.nextInt(31); // 10-40 rooms
            for (int j = 1; j <= numberOfRooms; j++) {
                Room room = new Room();
                room.setRoomNumber("Room " + j);
                room.setNumberOfBeds(1 + random.nextInt(4)); // 1-4 beds
                room.setHotel(hotel);
                room.setCreated(LocalDateTime.now()); // Set created field for Room
                room.setUpdated(LocalDateTime.now()); // Set updated field for Room
               // roomRepository.save(room);
            }
        }
        List<Hotel> hotels = hotelService.findHotelsByType("Family House");


        List<Room> rooms = roomRepository.findAvailableRoomsByDateAndHotel(1, LocalDate.parse("2024-01-15").atStartOfDay());
        System.out.println(rooms);
    }
}
