package org.fasttrackit.smarthome;

import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.service.RoomService;
import org.fasttrackit.smarthome.transfer.SaveRoomRequest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;


@SpringBootTest
public class RoomServiceIntegrationTest {


    @Autowired
    private RoomService roomService;

    @Test
    void createRoom_whenValidRequest_thenRoomIsCreated() {

        SaveRoomRequest request = new SaveRoomRequest();
        request.setName("Dormnitor");

        Room room = roomService.createRoom(request);

        assertThat(room, notNullValue());
        assertThat(room.getId(), greaterThan(0L));
        assertThat(room.getName(), is(request.getName()));
    }
}
