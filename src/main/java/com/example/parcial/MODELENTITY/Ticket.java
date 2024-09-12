package com.example.parcial.MODELENTITY;

import com.example.parcial.MODELENTITY.User;
import com.example.parcial.MODELENTITY.Event;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonManagedReference
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_event", insertable = false, updatable = false)
    @NotNull()
    @JsonManagedReference
    private Event event;

    public Ticket (User user, Event event) {
        this.user = user;
        this.event = event;
    }

    // Constructor without parameters
    public Ticket () {}

    // Return id_event in JSON
    @JsonProperty("id_event")
    public Long getEventId() {
        return event != null ? event.getId_event() : null;
    }
//    @JsonProperty("id_user")
//    public Long getUserId() {
//        return user != null ? user.getId_user() : null;
//    }

}
