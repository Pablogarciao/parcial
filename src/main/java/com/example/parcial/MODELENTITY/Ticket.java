package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.CompositeKey;
import com.example.parcial.MODELENTITY.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import com.example.parcial.MODELENTITY.User;
import lombok.Data;

@Entity
@Table(name="tickets")
@Data()
public class Ticket {
    @EmbeddedId
    private CompositeKey id;

    @ManyToOne
    @JoinColumn(name = "IDUser", insertable = false, updatable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "event", insertable = false, updatable = false)
    private Event event;



}

