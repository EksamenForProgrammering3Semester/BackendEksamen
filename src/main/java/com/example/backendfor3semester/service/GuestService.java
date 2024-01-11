package com.example.backendfor3semester.service;

import com.example.backendfor3semester.dto.GuestRequest;
import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.repository.GuestRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GuestService {

    private GuestRepository guestRepository;

    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public Guest createGuest(GuestRequest guestRequest){
        Guest guest = guestRequest.guestBuilder();
        return guestRepository.save(guest);
    }

    public Guest login(String username, String password) {

        return guestRepository.findByUsernameAndPassword(username, password);
    }
    public Optional<Guest> findGuestById(int id) {
        return guestRepository.findById(id);
    }
}
