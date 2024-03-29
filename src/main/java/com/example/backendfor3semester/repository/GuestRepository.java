package com.example.backendfor3semester.repository;

import com.example.backendfor3semester.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, Integer> {

    Guest findByUsernameAndPassword(String username, String password);

}
