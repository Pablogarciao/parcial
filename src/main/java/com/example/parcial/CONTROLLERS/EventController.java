package com.example.parcial.CONTROLLERS;

import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.EventEditDTO;
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

    @GetMapping("/event/{id}")
    public ResponseEntity<?> getEventById (@PathVariable Long id) {
        System.out.println("getEventById");

        Event e = eventService.findById(id);

        if( e==null ) return ResponseEntity.status(404).body("event not found");

        return ResponseEntity.status(200).body(e);
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

    @PostMapping("/event")
    public ResponseEntity<?> postEvent (@Valid @RequestBody EventDTO eventDTO) {
        System.out.println("postEvent");

        try{
            // TODO: rol validation

            // Create Event
            Event event = eventService.createEvent(eventDTO);

            // Create Media
            eventService.addMedia(event, eventDTO.getMedia());

            return ResponseEntity.status(201).body(event);
        } catch (IllegalArgumentException error){
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/event/{id}")
    public ResponseEntity<?> putEvent (@RequestBody EventEditDTO eventEditDTO, @PathVariable Long id) {
        System.out.println("putEvent");

        try{
            // TODO: rol validation

            // Edit EventMedia
            Event event = eventService.editEvent(eventEditDTO, id);

            return ResponseEntity.status(201).body(event);
        } catch (IllegalArgumentException error){
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
