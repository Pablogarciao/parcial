package com.example.parcial.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter()
@Setter()
public class EventMediaEvDTO {
    @NotNull
    private String media;

    @NotNull
    private Boolean favorite;
}
