package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IEventMediaDAO;
import com.example.parcial.DTO.EventMediaDTO;
import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.EventMedia;
import com.example.parcial.SERVICES.INTERFACES.IEventMediaService;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMediaService implements IEventMediaService {
    @Autowired
    private IEventMediaDAO eventMediaDAO;

    @Autowired
    private IEventService eventService;

    @Override
    public List<EventMedia> findAll() {
        return eventMediaDAO.findAll();
    }

    @Override
    public EventMedia save(EventMedia eventMedia) {return eventMediaDAO.save(eventMedia); }

    @Override
    public EventMedia findById(Long id) {return eventMediaDAO.findById(id).orElse(null); }

    @Override
    public void deleteById(Long id) { eventMediaDAO.deleteById(id); }

    @Transactional
    public EventMedia createEventMedia (EventMediaDTO eventMediaDTO) {
        // Event Validation
        Event event = eventService.getEvent(eventMediaDTO.getId_event());

        // Save EventMedia
        EventMedia eventMedia = new EventMedia(event, eventMediaDTO.getMedia(), eventMediaDTO.getFavorite());
        this.save(eventMedia);

        return eventMedia;
    }

    @Transactional
    public EventMedia editEventMedia(EventMediaDTO eventMediaDTO, Long id) {
        // EventMedia Validation
        EventMedia eventMedia = this.findById(id);

        if( eventMedia==null ) {
            throw new IllegalArgumentException("EventMedia not found");
        }

        // Edit Event Media
        if (eventMediaDTO.getId_event() != null && eventMediaDTO.getId_event() > 0) {
            eventMedia.setEvent(eventService.getEvent(eventMediaDTO.getId_event()));
        }
        eventMedia.setMedia(eventMediaDTO.getMedia());
        eventMedia.setFavorite(eventMediaDTO.getFavorite());

        // Save EventMedia
        this.save(eventMedia);

        return eventMedia;
    }
}
