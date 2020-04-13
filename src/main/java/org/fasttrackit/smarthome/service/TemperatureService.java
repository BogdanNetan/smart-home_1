package org.fasttrackit.smarthome.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.exception.ResourceNotFoundException;
import org.fasttrackit.smarthome.persistance.TemperatureRepository;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureService.class);

    private final TemperatureRepository temperatureRepository;
    private final ObjectMapper objectMapper;

    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository, ObjectMapper objectMapper) {
        this.temperatureRepository = temperatureRepository;
        this.objectMapper = objectMapper;
    }

    public Temperature createTemperature(SaveTemperatureRequest request) {

        LOGGER.info("Creating temperature {} ", request);

        Temperature temperature = objectMapper.convertValue(request, Temperature.class);

        return temperatureRepository.save(temperature);
    }

    public Temperature getTemperature(long id) {
        LOGGER.info("Retieving temperature {} ", id);

        return temperatureRepository.findById(id)
                //lambda expressions
                .orElseThrow(() -> new ResourceNotFoundException("Room" + id + " not found"));
    }

    public Temperature updateTemperature(long id, SaveTemperatureRequest request) {
        LOGGER.info("Updating temperature {}: {} ", id, request);

        Temperature temperature = getTemperature(id);

        BeanUtils.copyProperties(request, temperature);

        return temperatureRepository.save(temperature);
    }
}

