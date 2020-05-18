package com.pc4p.room;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/room")
@CrossOrigin(value = "http://localhost:63343")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> findAllRooms() {
        return roomService.findAllRooms();
    }

    @GetMapping("{id}")
    public Room findById(@PathVariable int id) {
        return roomService.findById(id);
    }
}
