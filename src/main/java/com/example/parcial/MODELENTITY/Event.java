package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="event")
@Data()
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column()
    @NotNull()
    private Date date;

    @Column()
    @NotNull()
    private String details;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EventMedia> media;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    // Pasar a User
    private Usuario lastUpdate;

//    @ManyToMany(mappedBy = "participations")
//    private Set<Portfolio> portfolios = new HashSet<>();
}
