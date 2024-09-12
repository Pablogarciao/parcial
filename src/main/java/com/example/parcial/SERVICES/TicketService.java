package com.example.parcial.SERVICES;

import com.example.parcial.DAO.ITicketDAO;
import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.TicketDTO;
import com.example.parcial.DTO.UserDTO;
import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.Ticket;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import com.example.parcial.SERVICES.INTERFACES.ITicketService;
import com.example.parcial.DAO.ITicketDAO;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
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

    @Autowired
    private IUserService userService;
    @Autowired
    private IEventService eventService;

    @Override
    public Ticket save(Ticket ticket) {return ticketDAO.save(ticket); }

    @Override
    public Ticket findById(Long id) {return ticketDAO.findById(id).orElse(null); }

    @Override
    public void deleteById(Long id) {ticketDAO.deleteById(id); }

    @Override
    public Ticket createTicket(TicketDTO ticketDTO) throws IllegalArgumentException {
        User user = userService.findById(ticketDTO.getUser_id());
        if(user == null) {
            throw new IllegalArgumentException("User not found");
        }
        Event event = eventService.findById(ticketDTO.getEvent_id());
        if(event == null) {
            throw new IllegalArgumentException("Event not found");
        }
        //System.out.println(user);
        //System.out.println(event);
        Ticket ticket = new Ticket();
        ticket.setUser(user);
        ticket.setEvent(event);
        //System.out.println(ticket);
//        save(ticket);

        return ticket;
    }

//    public User generateUser(TicketDTO ticketDTO) {
//
//        return userService.createUser(ticketDTO.getUser_id());
//    }
}
