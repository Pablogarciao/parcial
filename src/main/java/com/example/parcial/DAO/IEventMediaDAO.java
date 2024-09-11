package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.EventMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IEventMediaDAO extends JpaRepository<EventMedia, Long> {
    @Query("SELECT em FROM EventMedia em WHERE em.event.id_event = :idEvent")
    List<EventMedia> findByEvent(Long idEvent);

    @Query("SELECT em FROM EventMedia em WHERE em.favorite = :favorite")
    List<EventMedia> findByFavorite(Boolean favorite);
}
