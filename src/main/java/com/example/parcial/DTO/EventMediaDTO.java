package com.example.parcial.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class EventMediaDTO {
    @NotNull
    private Long id_event;

    @NotNull
    private String media;

    @NotNull
    private Boolean favorite;
}
