package org.fasttrackit.smarthome.transfer.temperature;


import java.util.List;

public class AddTemperatureToRoomRequest {

    private long roomId;
    private long temperatureId;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public long getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(long temperatureId) {
        this.temperatureId = temperatureId;
    }

    @Override
    public String toString() {
        return "AddTemperatureToRoomRequest{" +
                "roomId=" + roomId +
                ", temperatureId=" + temperatureId +
                '}';
    }
}

