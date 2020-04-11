package org.fasttrackit.smarthome.domain;

import javax.persistence.*;


@Entity
public class Light {

    @Id
    private long id;

    private boolean light;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Room room;

    public boolean isLight() {
        return light;
    }

    public void setLight(boolean light) {
        this.light = light;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Light{" +
                "id=" + id +
                ", light=" + light +
                '}';
    }
}
