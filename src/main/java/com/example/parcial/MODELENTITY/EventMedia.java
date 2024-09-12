package com.example.parcial.MODELENTITY;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JoinColumn(name = "id_event", nullable = false)
    @NotNull()
    @JsonBackReference
    private Event event;

    @Column()
    @NotNull()
    private String media;

    @Column
    @NotNull()
    private Boolean favorite;

    // Constructor with parameters
    public EventMedia (Event event, String media, Boolean favorite) {
        this.event = event;
        this.media = media;
        this.favorite = favorite;
    }

    // Constructor without parameters
    public EventMedia() {}

    // Return id_event in JSON
    @JsonProperty("id_event")
    public Long getEventId() {
        return event != null ? event.getId_event() : null;
    }
}
