package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.RoomRequest;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.RoomRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room createRoom(RoomRequest roomRequest, Hotel hotel){
        Room room = roomRequest.roomBuilder();
        room.setHotel(hotel);  // Set the hotel manually

        return roomRepository.save(room);
    }
    public Optional<Room> findRoomById(int roomId) {
        return roomRepository.findById(roomId);
    }
    public List<Room> getAllRoomsByHotelId(int hotelId) {
        return roomRepository.findAllByHotelId(hotelId);
    }
    public List<Room> findAvailableRoomsByDateAndHotel(int hotelId, LocalDate date) {
        LocalDateTime startOfDay = date.atStartOfDay();
        return roomRepository.findAvailableRoomsByDateAndHotel(hotelId, startOfDay);
    }

}
