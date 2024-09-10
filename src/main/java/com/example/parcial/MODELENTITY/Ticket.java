package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull()
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_event", insertable = false, updatable = false)
    @NotNull()
    private Event event;
}
