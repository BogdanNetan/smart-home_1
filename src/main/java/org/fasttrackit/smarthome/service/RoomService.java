package org.fasttrackit.smarthome.service;


import org.fasttrackit.smarthome.exception.ResourceNotFoundException;
import org.fasttrackit.smarthome.persistance.RoomRepository;
import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.transfer.room.GetRoomsRequest;
import org.fasttrackit.smarthome.transfer.room.SaveRoomRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class RoomService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

    private final RoomRepository roomRepository;


    //IoC
    //Dependecy Injection(from Ioc container)
    @Autowired
    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Room createRoom(SaveRoomRequest request) {
            LOGGER.info("Creating room {} ", request);

            Room room = new Room();
            room.setName(request.getName());

            return roomRepository.save(room);
    }

    public Room getRoom(long id) {
        LOGGER.info("Retieving room {} ", id);
        // prima varianta de a cauta camerele
//        Optional<Room> roomOptional = roomRepository.findById(id);
//
//        if (roomOptional.isPresent()) {
//            return roomOptional.get();
//        } else {
//            throw new ResourceNotFoundException("Room" + id + "not found.");
//        }

        return roomRepository.findById(id)
                //lambda expressions
                .orElseThrow(() -> new ResourceNotFoundException("Room" + id + " not found"));
    }

    public Page<Room> getAllRooms(GetRoomsRequest request, Pageable pageable) {
        LOGGER.info("Searching rooms : {} ", request);

        if (request != null) {
            if (request.getPartialName() != null) {
                roomRepository.findByNameContaining(request.getPartialName(), pageable);
                return roomRepository.findByNameContaining(request.getPartialName(), pageable);
            }
        }
        return roomRepository.findAll(pageable);
    }

    public Room updateRoom(long id, SaveRoomRequest request) {
        LOGGER.info("Updating room {}: {}", id, request);

        Room room = getRoom(id);

        BeanUtils.copyProperties(request, room);

        return roomRepository.save(room);
    }

    public void deleteRoom(long id) {
        LOGGER.info("Deleting room {}:", id);

        roomRepository.deleteById(id);
    }
}

