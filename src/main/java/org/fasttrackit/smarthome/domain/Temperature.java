package org.fasttrackit.smarthome.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Temperature {
    @Id
    @GeneratedValue
    private long id;

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

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", optimalValue=" + optimalValue +
                ", targetValue=" + targetValue +
                '}';
    }
}
