package com.example.parcial.CONTROLLERS;

import com.example.parcial.MODELENTITY.EventMedia;
import com.example.parcial.SERVICES.INTERFACES.IEventMediaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/api")
public class EventMediaController {
    @Autowired
    private IEventMediaService eventMediaService;

    @GetMapping("/event-media")
    public List<EventMedia> getEventMedia() {
        System.out.println("getEventMedia");
        return eventMediaService.findAll();
    }

    @PostMapping("/event-media")
    public ResponseEntity<?> postEventMedia (@Valid @RequestBody EventMedia eventMedia) {
        System.out.println("postEventMedia");

        Map<String,String> response= new HashMap<>();

        try{
            eventMediaService.save(eventMedia);
        } catch (Exception e){
            response.put("message",e.getMessage());
            return ResponseEntity.status(500).body(response);
        }

        return ResponseEntity.status(201).body(eventMedia);
    }

    @DeleteMapping("/event-media/{id}")
    public void deleteEventMedia (@PathVariable Long id) {
        System.out.println("deleteEventMedia");
        eventMediaService.deleteById(id);
    }

    @GetMapping("/event-media/{id}")
    public ResponseEntity<?> getEventMediaById (@PathVariable Long id) {
        System.out.println("getEventMediaById");

        EventMedia e = eventMediaService.findById(id);
        Map<String,String> response= new HashMap<>();

        if( e==null ) {
            response.put("message","EventMedia not found");
            return ResponseEntity.status(404).body(response);
        }

        return ResponseEntity.status(200).body(e);
    }

    @PutMapping("/event-media/{id}")
    public ResponseEntity<?> putEventMedia (@RequestBody EventMedia eventMedia, @PathVariable Long id) {
        System.out.println("putEventMedia");

        Map<String,String> response= new HashMap<>();

        try{
            EventMedia e = eventMediaService.findById(id);

            if( e==null ) {
                response.put("message","EventMedia not found");
                return ResponseEntity.status(404).body(response);
            }

            EventMedia EventMediaSaved = eventMediaService.save(eventMedia);
            return ResponseEntity.status(201).body(EventMediaSaved);
        } catch (Exception error){
            response.put("message",error.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}
