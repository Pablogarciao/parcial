package com.example.parcial.MODELENTITY;

import jakarta.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name="portfolio")
@Data
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_portfolio;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioMedia> media;

    @Column()
    private String biography;

    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Participation> participations;
}
