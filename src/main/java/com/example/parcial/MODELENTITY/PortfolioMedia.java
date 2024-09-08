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
    private CompositeKey id;

    @ManyToOne
    @JoinColumn(name = "id_portfolio", insertable = false, updatable = false)
    private Portfolio portfolio;

    @Column()
    @NotNull()
    private String media;



}