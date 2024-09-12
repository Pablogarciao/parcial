package com.example.parcial.SERVICES.INTERFACES;

import com.example.parcial.DTO.TicketDTO;
import com.example.parcial.DTO.UserDTO;
import com.example.parcial.MODELENTITY.Ticket;
import java.util.List;

public interface ITicketService {
    public List<Ticket> findAll();
    public Ticket save(Ticket event);
    public Ticket findById(Long id);
    public void deleteById(Long id);
    public Ticket createTicket(TicketDTO ticketDTO) throws IllegalArgumentException;

}
