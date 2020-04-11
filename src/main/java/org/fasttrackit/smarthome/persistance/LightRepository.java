package org.fasttrackit.smarthome.persistance;

import org.fasttrackit.smarthome.domain.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightRepository extends JpaRepository<Light, Long> {



}
