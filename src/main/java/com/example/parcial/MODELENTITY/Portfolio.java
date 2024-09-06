package com.example.parcial.MODELENTITY;

import javax.persistence.*;
import java.util.List;

@data
@Entity
@table(name="portafolio")
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

    @Column(name = biography)
    private String biography;
}
