package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.EventMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEventMediaDAO extends JpaRepository<EventMedia, Long> {
    @Query("SELECT e FROM Event e WHERE e.id = :IDEvent")
    List<EventMedia> findByEvent(Long idEvent);

    @Query("SELECT ev FROM EventMedia ev WHERE ev.favorite = :favorite")
    List<EventMedia> findByFavorite(Boolean favorite);
}
