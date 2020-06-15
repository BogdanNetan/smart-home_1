package org.fasttrackit.smarthome.transfer.room;

import javax.validation.constraints.NotNull;


public class SaveRoomRequest {


    @NotNull
    private String name;
    @NotNull
    private double targetValue;

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

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
                ", targetValue=" + targetValue +
                '}';
    }
}
