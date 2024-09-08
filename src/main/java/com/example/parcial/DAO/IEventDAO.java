package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface IEventDAO extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.date = :date")
    List<Event> findByDate(Date date);

//    @Query("SELECT e FROM Event e WHERE e.id = :idUser")
//    List<Event> findByUser(Long idUser);
}
