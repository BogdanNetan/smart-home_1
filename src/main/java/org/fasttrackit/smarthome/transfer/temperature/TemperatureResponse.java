package org.fasttrackit.smarthome.transfer.temperature;

import javax.validation.constraints.NotNull;

public class TemperatureResponse {

//    private long id;
    @NotNull
    private double targetValue;

//    public long getId() {
//        return id;
//    }

//    public void setId(long id) {
//        this.id = id;
//    }

    public double getTargetValue() {
        return targetValue;
    }

    public void setTargetValue(double targetValue) {
        this.targetValue = targetValue;
    }

    @Override
    public String toString() {
        return "TemperatureResponse{" +
//                "id=" + id +
                ", targetValue=" + targetValue +
                '}';
    }
}
