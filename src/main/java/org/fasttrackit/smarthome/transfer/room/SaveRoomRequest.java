package org.fasttrackit.smarthome.transfer.room;

import javax.validation.constraints.NotNull;


public class SaveRoomRequest {


    @NotNull
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "SaveRoomRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
