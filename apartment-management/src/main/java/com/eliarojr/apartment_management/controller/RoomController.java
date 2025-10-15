package com.eliarojr.apartment_management.controller;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.service.RoomService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    public RoomService roomService;

    private final Logger LOGGER = LoggerFactory.getLogger(RoomController.class);

    @PostMapping("/rooms")
    public Room saveRoom(@Valid @RequestBody Room room){
        LOGGER.info("Inside saveRoom of RoomController");
        return roomService.saveRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> fetchRoomList(){
        LOGGER.info("Inside fetchRoomList of RoomController");
        return roomService.fetchRoomList();
    }

    @GetMapping("/rooms/id/{id}")
    public Room fetchRoomById(@PathVariable("id")Long roomId){
        LOGGER.info("Inside fetchRoomById of RoomController");
        return roomService.fetchRoomById(roomId);
    }

    @GetMapping("/rooms/name/{name}")
    public Room fetchRoomByName(@PathVariable("name") String roomName){
        LOGGER.info("Inside fetchRoomByName of RoomController");
        return roomService.fetchRoomByName(roomName);
    }

    @DeleteMapping("/rooms/id/{id}")
    public String deleteRoomById(@PathVariable("id") Long roomId){
        roomService.deleteRoomById(roomId);
        LOGGER.info("Inside deleteRoomById of RoomController");
        return "Room deleted successfully!!";
    }

    @PutMapping("/rooms/id/{id}")
    public Room updateRoom(@PathVariable("id")Long roomId, @RequestBody Room room){
        LOGGER.info("Inside updateRoom of RoomController");
        return roomService.updateRoom(roomId,room);
    }

}
