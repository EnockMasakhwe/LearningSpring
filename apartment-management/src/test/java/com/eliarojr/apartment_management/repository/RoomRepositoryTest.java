package com.eliarojr.apartment_management.repository;

import com.eliarojr.apartment_management.entity.Room;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class RoomRepositoryTest {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {
        Room room = Room.builder()
                .roomName("3D")
                .roomAddress("Vision")
                .roomCode("VS-13")
                .build();
        entityManager.persist(room);
    }

    @Test
    @DisplayName("Get room from db based on id")
    public void whenFoundById_thenReturnRoom(){
        Room room  = roomRepository.findById(1L).get();
        assertEquals(room.getRoomName(),"3D");
    }
}