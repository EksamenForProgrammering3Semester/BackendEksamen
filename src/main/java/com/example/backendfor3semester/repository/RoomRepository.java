package com.example.backendfor3semester.repository;

import com.example.backendfor3semester.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT r FROM Room r WHERE r.hotel.id = :hotelId")
    List<Room> findAllByHotelId(@Param("hotelId") int hotelId);
}