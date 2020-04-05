package org.fasttrackit.smarthome.persistance;


import org.fasttrackit.smarthome.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;



public interface RoomRepository extends JpaRepository<Room, Long> {




}
