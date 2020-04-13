package org.fasttrackit.smarthome.transfer.temperature;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class SaveTemperatureRequest {

    @NotNull
    private double optimalValue;
    @NotNull
    private double targetValue;

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
                "optimalValue=" + optimalValue +
                ", targetValue=" + targetValue +
                '}';
    }
}
