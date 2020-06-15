package org.fasttrackit.smarthome.web;

import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.service.RoomService;
import org.fasttrackit.smarthome.transfer.room.GetRoomsRequest;
import org.fasttrackit.smarthome.transfer.room.SaveRoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/rooms")
public class RoomController {

    private final RoomService roomService;

    @Autowired
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping
    public ResponseEntity<Room> createRoom(@Valid @RequestBody SaveRoomRequest request) {
        Room room = roomService.createRoom(request);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable long id) {
        Room room = roomService.getRoom(id);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

        @GetMapping
    public ResponseEntity<Page<Room>> getAllRooms(GetRoomsRequest request, Pageable pageable) {
            Page<Room> allRooms = roomService.getAllRooms(request, pageable);
            return new ResponseEntity<>(allRooms, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable long id, @Valid @RequestBody SaveRoomRequest request) {
        Room room = roomService.updateRoom(id, request);
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRoom(@PathVariable long id) {
        roomService.deleteRoom(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
hg
