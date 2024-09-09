package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "participation")
@Data
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_participation;

    @ManyToOne
    @JoinColumn(name = "id_portfolio", nullable = false)
    private Portfolio portfolio;

    @ManyToOne
    @JoinColumn(name = "id_event", nullable = false)
    private Event event;
}
