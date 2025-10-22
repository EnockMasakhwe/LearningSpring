package com.eliarojr.apartment_management.service;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.error.RoomNotFoundException;
import com.eliarojr.apartment_management.repository.RoomRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceTest {

    @Autowired
    private RoomService roomService;

    @MockitoBean
    private RoomRepository roomRepository;

    @BeforeEach
    void setUp() {
        Room room = Room.builder()
                .roomName("2A")
                .roomAddress("Vision")
                .roomCode("VS-12")
                .roomId(1L)
                .build();
        Mockito.when(roomRepository.findRoomByRoomNameIgnoreCase("2A")).thenReturn(room);
    }

    @Test
    @DisplayName("Get data based on valid room name")
    public void whenValidRoomName_thenRoomShouldFound(){
        String roomName = "2A";
        Room found = roomService.fetchRoomByName(roomName);

        assertEquals(roomName, found.getRoomName());
    }

//    @Test
//    @DisplayName("Get data based on valid room id")
//    public void whenValidRoomId_thenRoomShouldFound() throws RoomNotFoundException {
//        Long roomId = 1L;
//        Room found = roomService.fetchRoomById(roomId);
//
//        assertEquals(roomId, found.getRoomId());
//    }
}