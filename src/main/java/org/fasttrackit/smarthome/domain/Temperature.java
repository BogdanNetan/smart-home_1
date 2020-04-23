package org.fasttrackit.smarthome.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Temperature {

    @Id
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Room room;



    @NotNull
    private double optimalValue;
    @NotNull
    private double targetValue;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", room=" + room +
                ", optimalValue=" + optimalValue +
                ", targetValue=" + targetValue +
                '}';
    }
}

