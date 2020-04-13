package org.fasttrackit.smarthome.persistance;

import org.fasttrackit.smarthome.domain.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemperatureRepository extends JpaRepository<Temperature, Long> {

}
