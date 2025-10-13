package com.eliarojr.apartment_management.service;

import com.eliarojr.apartment_management.entity.Room;

import java.util.List;

public interface RoomService {
    public Room saveRoom(Room room);

    public List<Room> fetchRoomList();

    public Room fetchRoomById(Long roomId);

    public Room fetchRoomByName(String roomName);

    public void deleteRoomById(Long roomId);

    public Room updateRoom(Long roomId, Room room);
}
