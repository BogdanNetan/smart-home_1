package org.fasttrackit.smarthome.transfer.room;

public class GetRoomsRequest {

    private String partialName;
    private double temperature;

    public String getPartialName() {
        return partialName;
    }

    @Override
    public String toString() {
        return "GetRoomsRequest{" +
                "partialName='" + partialName + '\'' +
                ", temperature=" + temperature +
                '}';
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public void setPartialName(String partialName) {
        this.partialName = partialName;
    }

}
