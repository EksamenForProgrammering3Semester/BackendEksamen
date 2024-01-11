package com.example.backendfor3semester.api;


import com.example.backendfor3semester.dto.GuestRequest;
import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.service.GuestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/guest")
public class GuestController {
    private GuestService guestService;

    public GuestController(GuestService guestService) {
        this.guestService = guestService;
    }

    @PostMapping("/create")
    public Guest createGuest(@RequestBody GuestRequest guestRequest) {
        return guestService.createGuest(guestRequest);
    }
    @GetMapping("/login")
    public ResponseEntity<Guest> login(@RequestParam String username, @RequestParam String password) {
        System.out.println("Received login request with username: " + username + " and password: " + password);

        Guest loggedInGuest = guestService.login(username, password);

        if (loggedInGuest != null) {
            System.out.println("Login successful for user: " + loggedInGuest.getUsername());
            return ResponseEntity.ok(loggedInGuest);
        } else {
            System.out.println("Login failed for username: " + username);
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    @GetMapping("/{id}")
    public Optional<Guest> findGuestById(@PathVariable int id) {
        return guestService.findGuestById(id);
    }


}
