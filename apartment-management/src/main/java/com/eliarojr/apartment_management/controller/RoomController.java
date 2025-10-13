package com.eliarojr.apartment_management.controller;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    public RoomService roomService;

    @PostMapping("/rooms")
    public Room saveRoom(@RequestBody Room room){
        return roomService.saveRoom(room);
    }

    @GetMapping("/rooms")
    public List<Room> fetchRoomList(){
        return roomService.fetchRoomList();
    }

    @GetMapping("/rooms/id/{id}")
    public Room fetchRoomById(@PathVariable("id")Long roomId){
        return roomService.fetchRoomById(roomId);
    }

    @GetMapping("/rooms/name/{name}")
    public Room fetchRoomByName(@PathVariable("name") String roomName){
        return roomService.fetchRoomByName(roomName);
    }

    @DeleteMapping("/rooms/id/{id}")
    public String deleteRoomById(@PathVariable("id") Long roomId){
        roomService.deleteRoomById(roomId);
        return "Room deleted successfully!!";
    }

    @PutMapping("/rooms/id/{id}")
    public Room updateRoom(@PathVariable("id")Long roomId, @RequestBody Room room){
        return roomService.updateRoom(roomId,room);
    }

}
