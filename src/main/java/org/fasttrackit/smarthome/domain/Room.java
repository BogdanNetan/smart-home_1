package org.fasttrackit.smarthome.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Room {

    @Id
//    @GeneratedValue
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "temperature_id"))
    private Temperature temperature;




    @NotNull
    private String name;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", temperature=" + temperature +
                ", name='" + name + '\'' +
                '}';
    }
}



