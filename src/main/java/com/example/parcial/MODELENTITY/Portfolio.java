package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.CompositeKey;
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
    @EmbeddedId
    private CompositeKey id;

    @ManyToOne
    @JoinColumn(name = "id_user", insertable = false, updatable = false)
    private User user;

    // Relación con PortfolioMedia (1 Portfolio puede tener varios PortfolioMedia)
    @OneToMany(mappedBy = "portfolio", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PortfolioMedia> media;

    @Column()
    private String biography;

    @ManyToMany ()@JoinTable(        name="participations",        joinColumns = @JoinColumn(name="id_portfolio"),
            inverseJoinColumns = @JoinColumn(name="id_event"))private List<Event> participations;

}


