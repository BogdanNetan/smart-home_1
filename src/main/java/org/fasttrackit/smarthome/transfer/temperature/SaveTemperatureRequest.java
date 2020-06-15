package org.fasttrackit.smarthome.transfer.temperature;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class SaveTemperatureRequest {

    @NotNull
    private String roomName;
    @NotNull
    private double optimalValue;
    @NotNull
    private double targetValue;

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getOptimalValue() {
        return optimalValue;
    }

    public void setOptimalValue(double optimalValue) {
        this.optimalValue = optimalValue;
    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public String toString() {
        return "SaveTemperatureRequest{" +
                "roomName='" + roomName + '\'' +
                ", optimalValue=" + optimalValue +
                ", targetValue=" + targetValue +
                '}';
    }
}
