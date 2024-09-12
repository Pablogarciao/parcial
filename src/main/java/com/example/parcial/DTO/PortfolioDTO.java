package com.example.parcial.DTO;

import com.example.parcial.DTO.MediaDTO;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PortfolioDTO {

    @NotNull
    private Long id_user;  // Assuming you're referencing the User by id

    private String biography;

    private List<PortfolioMediaDTO> media;  // List of media objects

    private List<Long> eventIds;  // Assuming you'll pass event IDs for participations
}
