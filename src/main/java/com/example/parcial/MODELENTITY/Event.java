package com.example.parcial.MODELENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
import java.util.Date;

@Entity
@Table(name="event")
@Data()
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event;

    @Column()
    @NotNull()
    private Date date;

    @Column()
    @NotNull()
    private String details;

    @ManyToOne
    @JoinColumn(name="lastUpdate", nullable = false)
    @NotNull()
    private User lastUpdate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<EventMedia> media;

    @ManyToMany(mappedBy = "participations")
    @JsonBackReference
    private List<Portfolio> portfolios;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
    private List<Ticket> tickets;

    // Constructor with parameters
    public Event (Date date, String details, User lastUpdate) {
        this.date = date;
        this.details = details;
        this.lastUpdate = lastUpdate;
    }

    // Constructor without parameters
    public Event () {}
}
