package org.fasttrackit.smarthome.steps;

//import org.fasttrackit.smarthome.domain.Temperature;
//import org.fasttrackit.smarthome.service.TemperatureService;
//import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import static org.hamcrest.CoreMatchers.is;
//import static org.hamcrest.MatcherAssert.assertThat;
//import static org.hamcrest.Matchers.greaterThan;
//import static org.hamcrest.core.IsNull.notNullValue;
//
//@Component
//public class TemperatureTestSteps {
//
//    @Autowired
//    private TemperatureService temperatureService;
//
//
//    public Temperature createTemperature() {
//        SaveTemperatureRequest request = new SaveTemperatureRequest();
//
//        request.setOptimalValue(21);
//        request.setTargetValue(22);
//
//        Temperature temperature = temperatureService.createTemperature(request);
//
//        assertThat(temperature, notNullValue());
//        assertThat(temperature.getId(), greaterThan(0L));
//        assertThat(temperature.getOptimalValue(), is(request.getOptimalValue()));
//        assertThat(temperature.getTargetValue(), is(request.getTargetValue()));
//
//        return temperature;
//    }
//}
