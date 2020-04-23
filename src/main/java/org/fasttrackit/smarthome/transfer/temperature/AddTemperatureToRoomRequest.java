package org.fasttrackit.smarthome.transfer.temperature;

import java.util.List;

public class AddTemperatureToRoomRequest {

    private long roomId;
    private List<Long> temperatureIds;

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public List<Long> getTemperatureIds() {
        return temperatureIds;
    }

    public void setTemperatureIds(List<Long> temperatureIds) {
        this.temperatureIds = temperatureIds;
    }

    @Override
    public String toString() {
        return "AddTemperatureToRoomRequest{" +
                "roomId=" + roomId +
                ", temperatureIds=" + temperatureIds +
                '}';
    }
}
