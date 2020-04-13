package org.fasttrackit.smarthome.web;

import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.service.TemperatureService;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/temperatures")
@RestController
public class TemperatureController {
//
    private final TemperatureService temperatureService;

    @Autowired
    public TemperatureController(TemperatureService temperatureService) {
        this.temperatureService = temperatureService;
    }

    @PostMapping
    public ResponseEntity<Temperature> createTemperature(@Valid @RequestBody SaveTemperatureRequest request) {

        Temperature temperature = temperatureService.createTemperature(request);
        return new ResponseEntity<>(temperature, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Temperature> updateTemperature(@PathVariable long id, @Valid @RequestBody SaveTemperatureRequest request) {

        Temperature temperature = temperatureService.updateTemperature(id, request);
        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

}
