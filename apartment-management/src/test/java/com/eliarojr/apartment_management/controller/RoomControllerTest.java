package com.eliarojr.apartment_management.controller;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.error.RoomNotFoundException;
import com.eliarojr.apartment_management.service.RoomService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.RequestResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RoomController.class)
class RoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private RoomService roomService;

    private Room room;

    @BeforeEach
    void setUp() {
        room = Room.builder()
                .roomName("4B")
                .roomAddress("Vision")
                .roomCode("VS-33")
                .roomId(1L)
                .build();
    }

    @Test
    void saveRoom() throws Exception {
        Room inputRoom = Room.builder()
                .roomName("4B")
                .roomAddress("Vision")
                .roomCode("VS-33")
                .roomId(1L)
                .build();

        Mockito.when(roomService.saveRoom(inputRoom)).thenReturn(room);

        mockMvc.perform(post("/rooms")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "\t\"roomName\":\"4B\",\n" +
                        "    \"roomCode\":\"VS-33\",\n" +
                        "    \"roomAddress\":\"Vision\"\n" +
                        "}")).andExpect(status().isOk());
    }

    @Test
    void fetchRoomById() throws Exception {
        Mockito.when(roomService.fetchRoomById(1L)).thenReturn(room);

        mockMvc.perform(get("/rooms/id/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.roomName").value(room.getRoomName()));
    }
}