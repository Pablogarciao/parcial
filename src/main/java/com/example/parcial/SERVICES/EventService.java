package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IEventDAO;
import com.example.parcial.DAO.IEventMediaDAO;
import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.EventEditDTO;
import com.example.parcial.DTO.MediaDTO;
import com.example.parcial.MODELENTITY.Event;
import com.example.parcial.MODELENTITY.EventMedia;
import com.example.parcial.MODELENTITY.User;
import com.example.parcial.SERVICES.INTERFACES.IEventService;
import com.example.parcial.SERVICES.INTERFACES.IUserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements IEventService {
    @Autowired
    private IEventDAO eventDAO;

    @Autowired
    private IEventMediaDAO eventMediaDAO;

    @Autowired
    private IUserService userService;

    @Override
    public List<Event> findAll() {
        return eventDAO.findAll();
    }

    @Override
    public Event save(Event event) {return eventDAO.save(event); }

    @Override
    public Event findById(Long id) {return eventDAO.findById(id).orElse(null); }

    @Override
    public void deleteById(Long id) { eventDAO.deleteById(id); }

    @Transactional
    public Event createEvent (EventDTO eventDTO) {
        // Test User
        User user = getUser();

        // Save Event
        Event event = new Event(eventDTO.getDate(), eventDTO.getDetails(), user);
        this.save(event);

        return event;
    }

    @Transactional
    public void addMedia (Event event, List<MediaDTO> mediaList) {
        if (mediaList != null) {
            for (MediaDTO media : mediaList) {
                eventMediaDAO.save(new EventMedia(event, media.getMedia(), media.getFavorite()));
            }
        }
    }

    @Transactional
    public Event editEvent (EventEditDTO eventEditDTO, Long id) {
        // Event Validation
        Event event = this.getEvent(id);

        // Edit Event
        event.setDate(eventEditDTO.getDate());
        event.setDetails(eventEditDTO.getDetails());

        // Save Event
        this.save(event);

        return event;
    }

    @Transactional
    public Event getEvent(Long id_event) {
        Event event = this.findById(id_event);

        if (event == null) {
            throw new IllegalArgumentException("Event not found");
        }

        return event;
    }

    private User getUser() {
        // Test User
        return userService.findById(1L);
    }
}
