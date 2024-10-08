package com.example.parcial.CONTROLLERS;

import com.example.parcial.DTO.TicketDTO;
import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.Ticket;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
import com.example.parcial.SERVICES.UserService;
import com.example.parcial.SERVICES.EventService;
import com.example.parcial.SERVICES.INTERFACES.ITicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class TicketController {
    @Autowired
    private ITicketService ticketService;
    @Autowired
    private IEventService eventService;
    @Autowired
    private IUserService userService;

    @GetMapping("/ticket")
    public List<Ticket> getTicket() {
        System.out.println("getTicket");
        return ticketService.findAll();
    }

    @PostMapping("/ticket")
    public ResponseEntity<?> postTicket (@Valid @RequestBody TicketDTO ticketDTO) {
        System.out.println("postTicket");

        Map<String,String> response= new HashMap<>();

        try{

            Ticket ticket = ticketService.createTicket(ticketDTO);
            ticketService.save(ticket);
            return ResponseEntity.status(201).body(ticket);
        } catch (Exception e){
            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

    }

    @DeleteMapping("/ticket/{id}")
    public void deleteTicket (@PathVariable Long id) {
        System.out.println("deleteTicket");
        ticketService.deleteById(id);
    }

    @GetMapping("/ticket/{id}")
    public ResponseEntity<?> getTicketById (@PathVariable Long id) {
        System.out.println("getTicketById");

        Ticket e = ticketService.findById(id);
        Map<String,String> response= new HashMap<>();

        if( e==null ) {
            response.put("message","Ticket not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(e);
    }

    @PutMapping("/ticket/{id}")
    public ResponseEntity<?> putTicket (@RequestBody TicketDTO ticketDTO, @PathVariable Long id) {
        System.out.println("putTicket");

        Map<String,String> response= new HashMap<>();

        try{
            Ticket e = ticketService.findById(id);
            Event event = eventService.findById(ticketDTO.getEvent_id());
            User u = userService.findById(ticketDTO.getUser_id());

            if( e==null ) {
                response.put("message","Ticket not found");
                return ResponseEntity.status(404).body(response);
            }
            e.setEvent(event);
            e.setUser(u);
            Ticket TicketSaved = ticketService.save(e);
            return ResponseEntity.status(201).body(TicketSaved);
        } catch (Exception error){
            response.put("message",error.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
