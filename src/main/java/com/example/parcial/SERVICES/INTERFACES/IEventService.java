package com.example.parcial.SERVICES.INTERFACES;

import com.example.parcial.DTO.EventDTO;
import com.example.parcial.DTO.EventEditDTO;
import com.example.parcial.DTO.MediaDTO;
import com.example.parcial.MODELENTITY.Event;

import java.util.List;

public interface IEventService {
    public List<Event> findAll();
    public Event save(Event event);
    public Event findById(Long id);
    public void deleteById(Long id);
    public Event getEvent(Long id_event);

    public Event createEvent (EventDTO eventDTO);
    public void addMedia (Event event, List<MediaDTO> mediaList);
    public Event editEvent (EventEditDTO eventEditDTO, Long id);
}
