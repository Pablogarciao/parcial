package com.example.parcial.DTO;

import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.User;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TicketDTO {
    @NotNull
    private Long user_id;

    @NotNull
    private Long event_id;

    @Override
    public String toString() {
        return "TicketDTO{" +
                "user_id=" + user_id +
                ", event_id=" + event_id +
                '}';
    }

}
