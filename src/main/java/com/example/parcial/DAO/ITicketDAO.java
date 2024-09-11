package com.example.parcial.DAO;

import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.User;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.parcial.MODELENTITY.Ticket;
import java.util.List;

public interface ITicketDAO extends JpaRepository<Ticket, Long>  {
    @Query("SELECT t FROM Ticket t WHERE t.id_ticket = :id")
    List<Ticket> findById_ticket(Id id);

    @Query("SELECT t FROM Ticket t WHERE t.user = :user")
    List<Ticket> findByUser(User user);

    @Query("SELECT t FROM Ticket t WHERE t.user.id_user = :userId")
    List<Ticket> findByUserId(@Param("userId") Long userId);

    @Query("SELECT t FROM Ticket t WHERE t.user.name = :userName")
    List<Ticket> findByUserName(@Param("userName") String userName);

    @Query("SELECT t FROM Ticket t WHERE t.event = :event")
    List<Ticket> findByEvent(@Param("event") Event event);
}
