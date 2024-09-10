package com.example.parcial.SERVICES;

import com.example.parcial.DAO.ITicketDAO;
import com.example.parcial.MODELENTITY.Ticket;
import com.example.parcial.SERVICES.INTERFACES.ITicketService;
import com.example.parcial.DAO.ITicketDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketDAO ticketDAO;

    @Override
    public List<Ticket> findAll() {
        return ticketDAO.findAll();
    }

    @Override
    public Ticket save(Ticket ticket) {return ticketDAO.save(ticket); }

    @Override
    public Ticket findById(Long id) {return ticketDAO.findById(id).orElse(null); }

    @Override
    public void deleteById(Long id) {ticketDAO.deleteById(id); }
}
