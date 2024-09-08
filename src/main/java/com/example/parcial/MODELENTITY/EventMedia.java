package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.CompositeKey;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name="event_media")
@Data()
public class EventMedia {
    @EmbeddedId
    private CompositeKey id_eventMedia;

    @ManyToOne
    @JoinColumn(name = "id_evento", insertable = false, updatable = false)
    private Event event;

    @Column()
    @NotNull()
    private String media;

    @Column()
    @NotNull()
    private Boolean favorite;
}
