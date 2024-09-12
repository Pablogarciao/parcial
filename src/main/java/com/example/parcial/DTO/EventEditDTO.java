package com.example.parcial.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter()
@Setter()
public class EventEditDTO {
    @NotNull
    private Date date;

    @NotNull
    private String details;
}
