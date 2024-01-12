package com.example.backendfor3semester;

import com.example.backendfor3semester.entity.Room;
import com.example.backendfor3semester.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ExtendWith(MockitoExtension.class)  // Use MockitoExtension for JUnit 5
public class RoomRepositoryTests {

    @Autowired
    @InjectMocks
    private RoomRepository roomRepository;

    @Mock
    private RoomRepository mockRoomRepository;

    /*
    @Test
    public void testFindAvailableRoomsNoReservationsOnDate() {
        // Arrange
        Mockito.when(mockRoomRepository.findAvailableRoomsByDateAndHotel(Mockito.anyInt(), Mockito.any(Date.class)))
                .thenReturn(Arrays.asList(new Room(), new Room())); // Mocking data

        // Act
        List<Room> availableRooms = mockRoomRepository.findAvailableRoomsByDateAndHotel(1, new Date(124, 0, 15));

        // Assert
        assertTrue(availableRooms.size() > 0);
    }

    @Test
    public void testFindAvailableRoomsReservationsOnDate() {
        // Arrange
        Mockito.when(mockRoomRepository.findAvailableRoomsByDateAndHotel(Mockito.anyInt(), Mockito.any(Date.class)))
                .thenReturn(Arrays.asList()); // Mocking an empty list for reservations

        // Act
        List<Room> availableRooms = mockRoomRepository.findAvailableRoomsByDateAndHotel(2, new Date(124, 0, 15));

        // Assert
        assertTrue(availableRooms.isEmpty());
    }
}



     */

}
