package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/event")
    public ResponseEntity<?> getEvent() {
        System.out.println("getEvent");

        try{
            List<Event> all = eventService.findAll();
            return ResponseEntity.status(200).body(all);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/event")
    public ResponseEntity<?> postEvent (@Valid @RequestBody Event event) {
        System.out.println("postEvent");

        try{
            eventService.save(event);
            return ResponseEntity.status(201).body(event);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/event/{id}")
    public ResponseEntity<?> deleteEvent (@PathVariable Long id) {
        System.out.println("deleteEvent");

        try{
            eventService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById (@PathVariable Long id) {
        System.out.println("getEventById");

        Event e = eventService.findById(id);

        if( e==null ) return ResponseEntity.status(404).body("event not found");

        return ResponseEntity.status(200).body(e);
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<?> putEvent (@RequestBody Event event, @PathVariable Long id) {
        System.out.println("putEvent");

        try{
            Event e = eventService.findById(id);

            if( e==null ) return ResponseEntity.status(404).body("EventMedia not found");

            // Modificar e
            eventService.save(e);
            return ResponseEntity.status(201).body(e);
        } catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
