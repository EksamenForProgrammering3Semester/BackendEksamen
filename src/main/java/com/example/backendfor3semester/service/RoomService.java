package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.RoomRequest;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.RoomRepository;
import org.springframework.stereotype.Service;

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
}
