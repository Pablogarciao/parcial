package com.example.parcial.MODELENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
@Data
@Entity
public class PortfolioMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // PK: ID
    private Long id;

    private String media;

    // FK hacia Portfolio
    @ManyToOne
    @JoinColumn(name = "id_portfolio", nullable = false)  // FK: IDPortfolio en el diagrama
    private Portfolio portfolio;

}