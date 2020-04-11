package org.fasttrackit.smarthome.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RoomService.class);

    private final UserService userService;

    @Autowired
    public UserService(UserService userService) {
        this.userService = userService;
    }



}
