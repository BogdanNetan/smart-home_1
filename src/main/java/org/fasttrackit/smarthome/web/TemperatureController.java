package org.fasttrackit.smarthome.web;
//

import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.service.TemperatureService;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.fasttrackit.smarthome.transfer.temperature.TemperatureResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RequestMapping("/temperatures")
@RestController
public class TemperatureController {

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

    @GetMapping("/{id}")
    public ResponseEntity<Temperature> getTemperature(@PathVariable String id) {
        Long longId = Long.parseLong(id);
        Temperature temperature = temperatureService.getTemperature(longId);

        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Page<Temperature>> getAllTemperature(SaveTemperatureRequest request, Pageable pageable) {
        Page<Temperature> allTemperature = temperatureService.getAllTemperatures(request, pageable);
        return new ResponseEntity<>(allTemperature, HttpStatus.OK);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Temperature> updateTemperature(@PathVariable long id,
                                                         @Valid @RequestBody SaveTemperatureRequest request) {

        Temperature temperature = temperatureService.updateTemperature(id, request);
        return new ResponseEntity<>(temperature, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteTemperature(@PathVariable long id) {
        temperatureService.deleteTemperature(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}



