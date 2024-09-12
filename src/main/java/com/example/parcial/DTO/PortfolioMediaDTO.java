package com.example.parcial.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PortfolioMediaDTO {

    @NotNull
    private Long id_portfolio;  // Reference to the Portfolio

    @NotNull
    private String media;  // The media link or file reference
}
