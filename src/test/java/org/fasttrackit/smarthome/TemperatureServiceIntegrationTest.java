package org.fasttrackit.smarthome;


import org.fasttrackit.smarthome.domain.Room;
import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.service.TemperatureService;
import org.fasttrackit.smarthome.steps.RoomTestSteps;
import org.fasttrackit.smarthome.steps.TemperatureTestSteps;
import org.fasttrackit.smarthome.steps.TemperatureTestSteps;
import org.fasttrackit.smarthome.transfer.temperature.AddTemperatureToRoomRequest;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@SpringBootTest
public class TemperatureServiceIntegrationTest {

    @Autowired
    private TemperatureService temperatureService;
    @Autowired
    private TemperatureTestSteps temperaturetestSteps;
    @Autowired
    private RoomTestSteps roomTestSteps;



    @Test
    void addTemperatureToRoom_whenNewRoom_thenRoomIsCreated() {
        Room room = roomTestSteps.createRoom();

        AddTemperatureToRoomRequest temperatureRequest = new AddTemperatureToRoomRequest();
        temperatureRequest.setRoomId(room.getId());

        temperatureService.addTemperaturesToRoom(temperatureRequest);
    }

    @Test
    void UpdateTemperature_whenValidRequest_thenReturnUpdatedTemperature() {
        Room room = roomTestSteps.createRoom();

        AddTemperatureToRoomRequest temperatureRequest = new AddTemperatureToRoomRequest();
        temperatureRequest.setRoomId(room.getId());
        temperatureRequest.setTargetValue(23);

        temperatureService.addTemperaturesToRoom(temperatureRequest);

        Temperature temperaturesForRoom = temperatureService.getTemperaturesForRoom(room.getId());

        assertThat(temperaturesForRoom.getTargetValue(), is(temperatureRequest.getTargetValue()));

        System.out.println("update...");

         temperatureRequest = new AddTemperatureToRoomRequest();
        temperatureRequest.setRoomId(room.getId());
        temperatureRequest.setTargetValue(25);



        temperatureService.addTemperaturesToRoom(temperatureRequest);

         temperaturesForRoom = temperatureService.getTemperaturesForRoom(room.getId());
        assertThat(temperaturesForRoom.getTargetValue(), is(temperatureRequest.getTargetValue()));


        System.out.println("upfae 25 grd");







//
//        Temperature temperature = temperaturetestSteps.createTemperature();
//        SaveTemperatureRequest request = new SaveTemperatureRequest();
//
//        request.setOptimalValue(temperature.getOptimalValue());
//        request.setTargetValue(temperature.getTargetValue());
//
//        Temperature updatedTemperature = temperatureService.updateTemperature(temperature.getId(),request);
//
//        assertThat(updatedTemperature, notNullValue());
//        assertThat(updatedTemperature.getId(), is(temperature.getId()));
//        assertThat(updatedTemperature.getOptimalValue(), is(request.getOptimalValue()));
//        assertThat(updatedTemperature.getTargetValue(), is(request.getTargetValue()));
    }





//    @Test
//    void createTemperature_whenValidRequest_thenTemperatureIsCreated() {
//        temperaturetestSteps.createTemperature();
//    }

//    @Test
//    void getTemperture_whenExistingTemperature_thenReturnTemperature() {
//        Temperature temperature = temperaturetestSteps.createTemperature();
//
//        Temperature response = temperatureService.getTemperature(temperature.getId());
//
//        assertThat(response, notNullValue());
//        assertThat(response.getId(), is(temperature.getId()));
//        assertThat(response.getOptimalValue(), is(temperature.getOptimalValue()));
//        assertThat(response.getTargetValue(), is(temperature.getTargetValue()));
//    }


//
//






//    public Temperature createTemperature() {
////
////        SaveTemperatureRequest request = new SaveTemperatureRequest();
////
////        request.setOptimalValue(21);
////        request.setTargetValue(21);
////
////        Temperature temperature = temperatureService.createTemperature(request);
////
////        assertThat(temperature, notNullValue());
////        assertThat(temperature.getId(), greaterThan(0L));
////        assertThat(temperature.getOptimalValue(), is(request.getOptimalValue()));
////        assertThat(temperature.getTargetValue(), is(request.getTargetValue()));
////        return temperature;
//    }
}







