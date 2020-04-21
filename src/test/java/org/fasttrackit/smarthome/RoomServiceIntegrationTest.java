package org.fasttrackit.smarthome;

import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.exception.ResourceNotFoundException;
import org.fasttrackit.smarthome.service.RoomService;
import org.fasttrackit.smarthome.steps.RoomTestSteps;
import org.fasttrackit.smarthome.steps.TemperatureTestSteps;
import org.fasttrackit.smarthome.transfer.room.AddTemperatureToRoomRequest;
import org.fasttrackit.smarthome.transfer.room.SaveRoomRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest
public class RoomServiceIntegrationTest {

    @Autowired
    private RoomService roomService;
    @Autowired
    private RoomTestSteps roomTestSteps;
    @Autowired
    private TemperatureTestSteps temperatureTestSteps;

    @Test
    void createRoom_whenValidRequest_thenRoomIsCreated() {

        roomTestSteps.createRoom();
    }

    @Test
    void getRoom_whenExistingRoom_thenReturn_Room() {
        Room room = roomTestSteps.createRoom();

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

        Room room = roomTestSteps.createRoom();

        SaveRoomRequest request = new SaveRoomRequest();
        request.setName(room.getName() + " updated ");

        Room updateRoom = roomService.updateRoom(room.getId(), request);

        assertThat(updateRoom, notNullValue());
        assertThat(updateRoom.getId(), is(room.getId()));
        assertThat(updateRoom.getName(), is(request.getName()));
    }

    @Test
    void deleteRoom_whenExistingRoom_thenRoomDoesNotExistAnyMore() {
        Room room = roomTestSteps.createRoom();


        roomService.deleteRoom(room.getId());

        Assertions.assertThrows(ResourceNotFoundException.class,
                () -> roomService.getRoom(room.getId()));
    }

    @Test
    void addTemperatureToRoom_whenNewRoom_thenRoomIsCreated() {
//        Room room = roomTestSteps.createRoom();
        Temperature temperature = temperatureTestSteps.createTemperature();

        AddTemperatureToRoomRequest roomRequest = new AddTemperatureToRoomRequest();

        roomRequest.setTemperatureId(temperature.getId());
//        roomRequest.setRoomIds(Collections.singletonList(room.getId()));

        roomService.addTemperatureToRoom(roomRequest);
    }


//    private Room createRoom() {
//
//        SaveRoomRequest request = new SaveRoomRequest();
//        request.setName("Dormnitor");
//
//        Room room = roomService.createRoom(request);
//
//        assertThat(room, notNullValue());
//        assertThat(room.getId(), greaterThan(0L));
//        assertThat(room.getName(), is(request.getName()));
//
//        return room;
//    }
}




