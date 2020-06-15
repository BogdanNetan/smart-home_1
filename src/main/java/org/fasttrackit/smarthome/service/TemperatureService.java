package org.fasttrackit.smarthome.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.fasttrackit.smarthome.domain.Temperature;
import org.fasttrackit.smarthome.exception.ResourceNotFoundException;
import org.fasttrackit.smarthome.persistance.TemperatureRepository;
import org.fasttrackit.smarthome.transfer.temperature.SaveTemperatureRequest;
import org.fasttrackit.smarthome.transfer.temperature.TemperatureResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TemperatureService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemperatureService.class);

    private final TemperatureRepository temperatureRepository;
    private final ObjectMapper objectMapper;
    private final RoomService roomService;


    @Autowired
    public TemperatureService(TemperatureRepository temperatureRepository, ObjectMapper objectMapper, RoomService roomService) {
        this.temperatureRepository = temperatureRepository;
        this.objectMapper = objectMapper;
        this.roomService = roomService;
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

    public Page<Temperature> getAllTemperatures(SaveTemperatureRequest request, Pageable pageable) {
        LOGGER.info("Searching temperatures : {} ", request);

        if (request != null) {
            if (request.getTargetValue() == 0) {
                temperatureRepository.findAll( pageable);
                return temperatureRepository.findAll( pageable);
            }
        }
        return temperatureRepository.findAll(pageable);
    }


    public Temperature updateTemperature(long id, SaveTemperatureRequest request) {
        LOGGER.info("Updating temperature {}: {} ", id, request);

        Temperature temperature = getTemperature(id);

        BeanUtils.copyProperties(request, temperature);

        return temperatureRepository.save(temperature);
    }

    public void deleteTemperature(long id) {
        LOGGER.info("Deleting temperature {}:", id);

        temperatureRepository.deleteById(id);
    }


//    @Transactional
//    public TemperatureResponse getTemperaturesFromRoom(long roomId) {
//
//        LOGGER.info(" Getting temperature from room: {} ", roomId);
//
//        Temperature temperature = temperatureRepository.findById(roomId).orElse(null);
//
//        TemperatureResponse temperatureResponse = new TemperatureResponse();
//        temperatureResponse.setId(temperature.getId());
//        temperatureResponse.setTargetValue(temperature.getTargetValue());
//
//        return temperatureResponse;
//    }
//
//    @Transactional
//    public Temperature addTemperaturesToRoom(AddTemperatureToRoomRequest request) {
//
//        LOGGER.info(" Adding temperature to room: {} ", request);
//
//        Temperature temperature = temperatureRepository.findById(request.getRoomId())
//                .orElse(new Temperature());
//
//        temperature.setOptimalValue(19);
//        temperature.setTargetValue(request.getTargetValue());
//
//        if (temperature.getRoom() == null) {
//            Room room = roomService.getRoom(request.getRoomId());
//            temperature.setRoom(room);
//        }
//
//        TemperatureResponse temperatureResponse = new TemperatureResponse();
//        temperatureResponse.setId(temperature.getId());
//        temperatureResponse.setTargetValue(temperature.getTargetValue());
//
//        temperatureRepository.save(temperature);
//        return temperature;
//    }
}

