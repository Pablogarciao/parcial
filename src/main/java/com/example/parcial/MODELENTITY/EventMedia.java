package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="event_media")
@Data()
public class EventMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_event_media;

    @ManyToOne
    @JoinColumn(name = "id_event", insertable = false, nullable = false)
    private Event event;

    @Column()
    @NotNull()
    private String media;

    @Column
    @NotNull()
    private Boolean favorite;
}
