package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.EventMedia;
import com.example.parcial.SERVICES.INTERFACES.IEventMediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api")
public class EventMediaController {
    @Autowired
    private IEventMediaService eventMediaService;

    @GetMapping("/event-media")
    public ResponseEntity<?> getEventMedia() {
        System.out.println("getEventMedia");

        try{
            List<EventMedia> all = eventMediaService.findAll();
            return ResponseEntity.status(200).body(all);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/event-media")
    public ResponseEntity<?> postEventMedia (@Valid @RequestBody EventMedia eventMedia) {
        System.out.println("postEventMedia");

        try{
            eventMediaService.save(eventMedia);
            return ResponseEntity.status(201).body(eventMedia);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/event-media/{id}")
    public ResponseEntity<?> deleteEventMedia (@PathVariable Long id) {
        System.out.println("deleteEventMedia");

        try{
            eventMediaService.deleteById(id);
            return ResponseEntity.status(204).build();
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/event-media/{id}")
    public ResponseEntity<?> getEventMediaById (@PathVariable Long id) {
        System.out.println("getEventMediaById");

        try{
            EventMedia e = eventMediaService.findById(id);

            if( e==null ) return ResponseEntity.status(404).body("EventMedia not found");

            return ResponseEntity.status(200).body(e);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/event-media/{id}")
    public ResponseEntity<?> putEventMedia (@RequestBody EventMedia eventMedia, @PathVariable Long id) {
        System.out.println("putEventMedia");

        try{
            EventMedia e = eventMediaService.findById(id);

            if( e==null ) return ResponseEntity.status(404).body("EventMedia not found");

            // Modificar e
            eventMediaService.save(e);
            return ResponseEntity.status(201).body(e);
        } catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
