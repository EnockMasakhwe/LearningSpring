package com.eliarojr.apartment_management.controller;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController {

    @Autowired
    public RoomService roomService;

    @PostMapping("/rooms")
    public Room saveRoom(@RequestBody Room room){
        return roomService.saveRoom(room);
    }
}
