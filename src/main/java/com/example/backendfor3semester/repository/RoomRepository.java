package com.example.backendfor3semester.repository;

import com.example.backendfor3semester.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId")
    List<Room> findAllByHotelId(@Param("hotelId") int hotelId);


    @Query("SELECT r FROM Room r LEFT JOIN Reservation res " +
            "ON r.id = res.room.id " +
            "WHERE r.hotel.id = :hotelId " +
            "AND (:dateParam >= res.reservationDate OR res.reservationDate IS NULL) " +
            "AND (:dateParam < res.updated OR res.updated IS NULL)")
    List<Room> findAvailableRoomsByDateAndHotel(@Param("hotelId") int hotelId, @Param("dateParam") LocalDateTime date);





}