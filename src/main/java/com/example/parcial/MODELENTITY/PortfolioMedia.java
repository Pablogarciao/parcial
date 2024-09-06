package com.example.parcial.MODELENTITY;

import javax.persistence.*;

@Entity
public class PortfolioMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // PK: ID
    private Long id;

    private String media;
    private String URL;

    // FK hacia Portfolio
    @ManyToOne
    @JoinColumn(name = "id_portfolio", nullable = false)  // FK: IDPortfolio en el diagrama
    private Portfolio portfolio;

}