package com.eliarojr.apartment_management.service;

import com.eliarojr.apartment_management.entity.Room;
import com.eliarojr.apartment_management.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    public RoomRepository roomRepository;

    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> fetchRoomList() {
        return roomRepository.findAll();
    }

    @Override
    public Room fetchRoomById(Long roomId) {
        return roomRepository.findById(roomId).get();
    }

    @Override
    public Room fetchRoomByName(String roomName) {
        return roomRepository.findRoomByRoomNameIgnoreCase(roomName);
    }

    @Override
    public void deleteRoomById(Long roomId) {
        roomRepository.deleteById(roomId);
    }

    @Override
    public Room updateRoom(Long roomId, Room room) {
        Room roomDB = roomRepository.findById(roomId).get();

        if(Objects.nonNull(room.getRoomName())&&
        !"".equalsIgnoreCase(room.getRoomName())){
            roomDB.setRoomName(room.getRoomName());
        }
        if(Objects.nonNull(room.getRoomAddress())&&
        !"".equalsIgnoreCase(room.getRoomAddress())){
            roomDB.setRoomAddress(room.getRoomAddress());
        }
        if(Objects.nonNull(room.getRoomCode())&&
        !"".equalsIgnoreCase(room.getRoomCode())){
            roomDB.setRoomCode(room.getRoomCode());
        }

        return roomRepository.save(roomDB);
    }
}
