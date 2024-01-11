package com.example.backendfor3semester.api;

import com.example.backendfor3semester.dto.ReservationRequest;
import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.entity.Reservation;
import com.example.backendfor3semester.service.ReservationService;
import com.example.backendfor3semester.service.RoomService;
import com.example.backendfor3semester.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;
    private final RoomService roomService;
    private final GuestService guestService;

    @Autowired
    public ReservationController(ReservationService reservationService, RoomService roomService, GuestService guestService) {
        this.reservationService = reservationService;
        this.roomService = roomService;
        this.guestService = guestService;
    }

    @PostMapping("/create")
    public Reservation createReservation(@RequestBody ReservationRequest reservationRequest) {
        // Fetch Room and Guest based on IDs or other criteria
        Room room = roomService.findRoomById(reservationRequest.getRoom())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        Guest guest = guestService.findGuestById(reservationRequest.getGuest())
                .orElseThrow(() -> new RuntimeException("Guest not found"));

        // Create Reservation
        return reservationService.createReservation(reservationRequest, room, guest);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservations() {
        List<Reservation> reservations = reservationService.getAllReservations();
        return ResponseEntity.ok(reservations);
    }
    @CrossOrigin("*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteReservation(@PathVariable int id) {
        try {
            reservationService.deleteReservationById(id);
            return new ResponseEntity<>("Reservation deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete reservation: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}