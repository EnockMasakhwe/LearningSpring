package com.eliarojr.apartment_management.service;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    public RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }
}
