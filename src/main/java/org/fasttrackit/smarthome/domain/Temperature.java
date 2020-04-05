package org.fasttrackit.smarthome.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Temperature {

    @Id
    private double temperature;


}
