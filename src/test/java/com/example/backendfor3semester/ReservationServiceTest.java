package com.example.backendfor3semester;

import com.example.backendfor3semester.dto.ReservationRequest;
import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.entity.Reservation;
import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.ReservationRepository;
import com.example.backendfor3semester.service.ReservationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class ReservationServiceTest {

    @Mock
    private ReservationRepository reservationRepository;

    @InjectMocks
    private ReservationService reservationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testCreateReservation() {
        // Create mock data
        ReservationRequest reservationRequest = new ReservationRequest();
        Room room = new Room();
        Guest guest = new Guest();

        when(reservationRepository.save(any(Reservation.class))).thenReturn(new Reservation());

        Reservation result = reservationService.createReservation(reservationRequest, room, guest);

        verify(reservationRepository, times(1)).save(any(Reservation.class));


    }

    @Test
    void testFindReservationById() {
        int reservationId = 1;

        when(reservationRepository.findById(reservationId)).thenReturn(Optional.of(new Reservation()));

        Optional<Reservation> result = reservationService.findReservationById(reservationId);

        verify(reservationRepository, times(1)).findById(reservationId);


    }

    @Test
    void testGetAllReservations() {
        when(reservationRepository.findAll()).thenReturn(Collections.emptyList());

        List<Reservation> result = reservationService.getAllReservations();

        verify(reservationRepository, times(1)).findAll();


    }

    @Test
    void testDeleteReservationById() {
        int reservationId = 1;

        reservationService.deleteReservationById(reservationId);

        verify(reservationRepository, times(1)).deleteById(reservationId);
    }
}