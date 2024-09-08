package com.example.parcial.MODELENTITY;

import com.example.parcial.UTILS.CompositeKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class PortfolioMedia {
    @EmbeddedId
    private CompositeKey id_portfolioMedia;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "id_portfolio", referencedColumnName = "idPart1", insertable = false, updatable = false),
            @JoinColumn(name = "id_user", referencedColumnName = "idPart2", insertable = false, updatable = false)
    })
    private Portfolio portfolio;

    @Column()
    @NotNull()
    private String media;
}