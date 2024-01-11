package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.ReservationRequest;
import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.entity.Reservation;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public Reservation createReservation(ReservationRequest reservationRequest, Room room, Guest guest) {
        Reservation reservation = reservationRequest.reservationBuilder();
        reservation.setRoom(room);
        reservation.setGuest(guest);
        return reservationRepository.save(reservation);
    }

    public Optional<Reservation> findReservationById(int id) {
        return reservationRepository.findById(id);
    }
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }
    public void deleteReservationById(int id) {
        reservationRepository.deleteById(id);
    }

}
