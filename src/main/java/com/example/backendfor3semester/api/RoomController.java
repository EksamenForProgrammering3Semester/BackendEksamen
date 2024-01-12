package com.example.backendfor3semester.api;


import com.example.backendfor3semester.dto.HotelRequest;
import com.example.backendfor3semester.dto.RoomRequest;
import com.example.backendfor3semester.entity.Hotel;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.service.HotelService;
import com.example.backendfor3semester.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    private final HotelService hotelService;

    public RoomController(RoomService roomService, HotelService hotelService) {
        this.roomService = roomService;
        this.hotelService = hotelService;
    }
    @PostMapping("/create")
    public ResponseEntity<Room> createHotel(@RequestBody RoomRequest roomRequest) {
        Hotel hotel = hotelService.getHotelById(roomRequest.getHotelId());
        Room room = roomService.createRoom(roomRequest, hotel);
        return ResponseEntity.ok(room);
    }

    @GetMapping("/hotel/{id}")
    public List<Room> getAllRoomsByHotelId(@PathVariable int id) {
        return roomService.getAllRoomsByHotelId(id);
    }
    @GetMapping("/{roomId}")
    public ResponseEntity<Room> getRoomById(@PathVariable int roomId) {
        Optional<Room> roomOptional = roomService.findRoomById(roomId);

        return roomOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
