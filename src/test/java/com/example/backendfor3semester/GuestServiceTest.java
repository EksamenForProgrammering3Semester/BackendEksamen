package com.example.backendfor3semester;


import com.example.backendfor3semester.entity.Guest;
import com.example.backendfor3semester.repository.GuestRepository;
import com.example.backendfor3semester.service.GuestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class GuestServiceTest {

    @Mock
    private GuestRepository guestRepository;

    @InjectMocks
    private GuestService guestService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogin_ValidCredentials() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        Guest guest = new Guest();
        guest.setUsername(username);
        guest.setPassword(password);

        when(guestRepository.findByUsernameAndPassword(anyString(), anyString())).thenReturn(guest);

        // Act
        Guest loggedInGuest = guestService.login(username, password);

        // Assert
        assertEquals(username, loggedInGuest.getUsername());
        assertEquals(password, loggedInGuest.getPassword());
    }

    @Test
    public void testLogin_InvalidCredentials() {
        // Arrange
        String username = "testUser";
        String password = "testPassword";

        when(guestRepository.findByUsernameAndPassword(anyString(), anyString())).thenReturn(null);

        // Act
        Guest loggedInGuest = guestService.login(username, password);

        // Assert
        assertEquals(null, loggedInGuest);
    }
}
