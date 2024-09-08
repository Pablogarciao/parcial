package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.util.List;
import java.util.Date;
import java.util.Set;

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

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EventMedia> media;

    @ManyToMany(mappedBy = "participations")
    private List<Portfolio> portfolios;

    //YO LO AGREGUÉ
//    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    private User lastUpdate;

}
