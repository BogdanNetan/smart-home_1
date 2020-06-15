package org.fasttrackit.smarthome.persistance;


import org.fasttrackit.smarthome.domain.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.Query;


public interface RoomRepository extends JpaRepository<Room, Long> {

    Page<Room> findByNameContaining(String partialName, Pageable pageable);


    @Query("SELECT  room FROM Room  room where name LIKE '%:partialName%'")
    Page<Room> findByPartialName(String partialName, Pageable pageable);
}
