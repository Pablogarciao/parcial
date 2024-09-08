package com.example.parcial.MODELENTITY;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="portafolio")
public class Portfolio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // PK: ID
    private Long id;


    // FK hacia User
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)  // FK: IDUser en el diagrama
    private Usuario user;

    // Relación con PortfolioMedia (1 Portfolio puede tener varios PortfolioMedia)
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioMedia> media;

    @Column(name = "biography")
    private String biography;

}


