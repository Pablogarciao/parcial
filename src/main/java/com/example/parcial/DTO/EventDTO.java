package com.example.parcial.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter()
@Setter()
public class EventDTO {
    @NotNull
    private Date date;

    @NotNull
    private String details;

    private List<EventMediaEvDTO> media;
}
