package com.example.backendfor3semester.repository;

import com.example.backendfor3semester.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    @Query("SELECT COUNT(r) FROM Room r WHERE r.hotel.id = :hotelId")
    int countRoomsByHotelId(@Param("hotelId") Integer hotelId);
}
