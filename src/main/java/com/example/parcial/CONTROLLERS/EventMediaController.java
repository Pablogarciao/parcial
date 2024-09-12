package com.example.parcial.CONTROLLERS;

import com.example.parcial.DAO.IEventMediaDAO;
import com.example.parcial.DTO.EventMediaDTO;
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

    @Autowired
    private IEventMediaDAO eventMediaDAO;

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

    @GetMapping("/event-media/event/{id}")
    public ResponseEntity<?> getEventMediaByEventId (@PathVariable Long id) {
        System.out.println("getEventMediaByEventId");

        try{
            List<EventMedia> em = eventMediaDAO.findByEvent(id);
            return ResponseEntity.status(200).body(em);
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/event-media/favorite/{favorite}")
    // Gallery
    public ResponseEntity<?> getEventMediaByFavorite (@PathVariable Boolean favorite) {
        System.out.println("getEventMediaByEventId");

        try{
            List<EventMedia> em = eventMediaDAO.findByFavorite(favorite);
            return ResponseEntity.status(200).body(em);
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

    @PostMapping("/event-media")
    public ResponseEntity<?> postEventMedia (@Valid @RequestBody EventMediaDTO eventMediaDTO) {
        System.out.println("postEventMedia");

        try {
            // TODO: rol validation

            // Save EventMedia
            EventMedia eventMedia = eventMediaService.createEventMedia(eventMediaDTO);

            return ResponseEntity.status(201).body(eventMedia);
        } catch (IllegalArgumentException error){
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/event-media/{id}")
    public ResponseEntity<?> putEventMedia (@RequestBody EventMediaDTO eventMediaDTO, @PathVariable Long id) {
        System.out.println("putEventMedia");

        try {
            // TODO: rol validation

            // Edit EventMedia
            EventMedia eventMedia = eventMediaService.editEventMedia(eventMediaDTO, id);

            return ResponseEntity.status(201).body(eventMedia);
        } catch (IllegalArgumentException error){
            return ResponseEntity.status(400).body(error.getMessage());
        } catch (Exception error){
            return ResponseEntity.status(500).body(error.getMessage());
        }
    }
}
