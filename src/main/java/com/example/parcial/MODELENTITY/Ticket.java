package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="tickets")
@Data()
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_ticket;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_event", insertable = false, updatable = false)
    private Event event;
}
