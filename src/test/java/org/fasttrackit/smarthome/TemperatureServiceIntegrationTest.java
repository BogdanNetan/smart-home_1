package org.fasttrackit.smarthome;

import org.fasttrackit.smarthome.service.TemperatureService;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TemperatureServiceIntegrationTest {

    @Autowired
    private TemperatureService temperatureService;

    @Test
    void createTemperature() {

        SaveTemperatureRequest request = new SaveTemperatureRequest();

        request.

        temperatureService.createTemperature()

    }


}
