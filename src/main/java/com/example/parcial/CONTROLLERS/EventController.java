package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class EventController {
    @Autowired
    private IEventService eventService;

    @GetMapping("/event")
    public List<Event> getEvent() {
        System.out.println("getEvent");
        return eventService.findAll();
    }

    @PostMapping("/event")
    public ResponseEntity<?> postEvent (@Valid @RequestBody Event event) {
        System.out.println("postEvent");

        Map<String,String> response= new HashMap<>();

        try{
            eventService.save(event);
        } catch (Exception e){
            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(event);
    }

    @DeleteMapping("/event/{id}")
    public void deleteEvent (@PathVariable Long id) {
        System.out.println("deleteEvent");
        eventService.deleteById(id);
    }

    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById (@PathVariable Long id) {
        System.out.println("getEventById");

        Event e = eventService.findById(id);
        Map<String,String> response= new HashMap<>();

        if( e==null ) {
            response.put("message","event not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(e);
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<?> putEvent (@RequestBody Event event, @PathVariable Long id) {
        System.out.println("putEvent");

        Map<String,String> response= new HashMap<>();

        try{
            Event e = eventService.findById(id);

            if( e==null ) {
                response.put("message","EventMedia not found");
                return ResponseEntity.status(404).body(response);
            }

            Event EventSaved = eventService.save(event);
            return ResponseEntity.status(201).body(EventSaved);
        } catch (Exception error){
            response.put("message",error.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
