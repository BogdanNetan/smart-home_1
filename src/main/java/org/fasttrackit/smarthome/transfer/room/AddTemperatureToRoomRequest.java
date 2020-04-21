package org.fasttrackit.smarthome.transfer.room;

import java.util.List;

public class AddTemperatureToRoomRequest {

    private long temperatureId;
    private List<Long> roomIds;

    public long getTemperatureId() {
        return temperatureId;
    }

    public void setTemperatureId(long temperatureId) {
        this.temperatureId = temperatureId;
    }

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }

    @Override
    public String toString() {
        return "AdTemperatureToRoom{" +
                "temperatureId=" + temperatureId +
                ", roomIds=" + roomIds +
                '}';
    }
}
