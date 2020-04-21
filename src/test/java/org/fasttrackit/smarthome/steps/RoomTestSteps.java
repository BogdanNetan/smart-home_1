package org.fasttrackit.smarthome.steps;

import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.service.RoomService;
import org.fasttrackit.smarthome.transfer.room.SaveRoomRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNull.notNullValue;

@Component
public class RoomTestSteps {

    @Autowired
    private RoomService roomService;


    public Room  createRoom() {

        SaveRoomRequest request = new SaveRoomRequest();
        request.setName("Dormnitor");

        Room room = roomService.createRoom(request);

        assertThat(room, notNullValue());
        assertThat(room.getId(), greaterThan(0L));
        assertThat(room.getName(), is(request.getName()));
        return room;
    }
}

