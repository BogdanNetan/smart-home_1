package org.fasttrackit.smarthome.transfer.room;

import javax.validation.constraints.NotNull;


public class SaveRoomRequest {


    @NotNull
    private String name;
    private double temperature;

    @Override
    public String toString() {
        return "SaveRoomRequest{" +
                "name='" + name + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
