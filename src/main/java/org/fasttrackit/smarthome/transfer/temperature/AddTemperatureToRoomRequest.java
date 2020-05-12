package org.fasttrackit.smarthome.transfer.temperature;


import javax.validation.constraints.NotNull;
import java.util.List;

public class AddTemperatureToRoomRequest {

        private long roomId;
    @NotNull
    private double targetValue;

        public long getRoomId() {
            return roomId;
        }

        public void setRoomId(long roomId) {
            this.roomId = roomId;
        }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public String toString() {
        return "AddTemperatureToRoomRequest{" +
                "roomId=" + roomId +
                ", targetValue=" + targetValue +
                '}';
    }
}

