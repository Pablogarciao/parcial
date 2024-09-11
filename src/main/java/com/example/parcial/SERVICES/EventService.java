package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IEventDAO;
import com.example.parcial.DAO.IEventMediaDAO;
import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.EventMediaEvDTO;
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
    public Event createEvent (EventDTO eventDTO) throws IllegalArgumentException {
        // Test User
        User user = userService.findById(1L);

        // Save Event
        Event event = new Event(eventDTO.getDate(), eventDTO.getDetails(), user);
        this.save(event);

        return event;
    }

    @Transactional
    public void addMedia (List<EventMediaEvDTO> mediaList, Event event) throws IllegalArgumentException {
        if (mediaList != null) {
            for (EventMediaEvDTO media : mediaList) {
                eventMediaDAO.save(new EventMedia(event, media.getMedia(), media.getFavorite()));
            }
        }
    }
}
