package org.fasttrackit.smarthome.service;

import org.fasttrackit.smarthome.domain.Light;
import org.fasttrackit.smarthome.persistance.LightRepository;
import org.fasttrackit.smarthome.transfer.light.AddLightToRoomRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LightService {
    private static final Logger LOGGER = LoggerFactory.getLogger(LightService.class);

    private final LightRepository lightRepository;

    @Autowired
    public LightService(LightRepository lightRepository) {
        this.lightRepository = lightRepository;
    }


    public void addRLightsToRoom(AddLightToRoomRequest request) {

        LOGGER.info("Adding lights to rooms:{}", request);

//        lightRepository.findById(request.getRoomId()).orElseThrow(new Light());


    }
}
