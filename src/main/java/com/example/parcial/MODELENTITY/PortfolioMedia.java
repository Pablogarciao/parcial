package com.example.parcial.MODELENTITY;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class PortfolioMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_portfolio_media;

    @ManyToOne
    @JoinColumn(name = "id_portfolio", insertable = false, nullable = false)
    private Portfolio portfolio;

    @Column()
    @NotNull()
    private String media;
}
