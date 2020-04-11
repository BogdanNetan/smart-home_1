package org.fasttrackit.smarthome;

import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.exception.ResourceNotFoundException;
import org.fasttrackit.smarthome.service.RoomService;
import org.fasttrackit.smarthome.transfer.room.SaveRoomRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest
public class RoomServiceIntegrationTest {

    @Autowired
    private RoomService roomService;
    @Test
    void createRoom_whenValidRequest_thenRoomIsCreated() {

        createRoom();
    }
    @Test
    void getRoom_whenExistingRoom_thenReturn_Room() {
        Room room = createRoom();

        Room response = roomService.getRoom(room.getId());

        assertThat(response, notNullValue());
        assertThat(response.getId(), is(room.getId()));
        assertThat(response.getName(), is(room.getName()));
    }

    @Test
    void getRoom_whenNonExistingRoom_thenThrowResourcesNotFoundException() {
        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> roomService.getRoom(564556464));
    }


    @Test
    void UpdateRoom_whenValidRequest_thenReturnUpdatedRoom() {

        Room room = createRoom();

        SaveRoomRequest request = new SaveRoomRequest();
        request.setName(room.getName() + " updated ");

        Room updateRoom = roomService.updateRoom(room.getId(), request);

        assertThat(updateRoom, notNullValue());
        assertThat(updateRoom.getId(), is(room.getId()));
        assertThat(updateRoom.getName(), is(request.getName()));
    }

    @Test
    void deleteRoom_whenExistingRoom_thenRoomDoesNotExistAnyMore() {
        Room room = createRoom();

        roomService.deleteRoom(room.getId());

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> roomService.getRoom(room.getId()));
    }


    private Room createRoom() {


        SaveRoomRequest request = new SaveRoomRequest();
        request.setName("Dormnitor");

        Room room = roomService.createRoom(request);

        assertThat(room, notNullValue());
        assertThat(room.getId(), greaterThan(0L));
        assertThat(room.getName(), is(request.getName()));

        return room;
    }
}




