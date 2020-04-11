package org.fasttrackit.smarthome.transfer.light;

import java.util.List;

public class AddLightToRoomRequest {
    private long roomId;
    private List<Long> roomIds;

    public List<Long> getRoomIds() {
        return roomIds;
    }

    public long getRoomId() {
        return roomId;
    }

    public void setRoomId(long roomId) {
        this.roomId = roomId;
    }

    public void setRoomIds(List<Long> roomIds) {
        this.roomIds = roomIds;
    }

    @Override
    public String toString() {
        return "AddLightToRoomRequest{" +
                "roomId=" + roomId +
                ", roomIds=" + roomIds +
                '}';
    }
}
