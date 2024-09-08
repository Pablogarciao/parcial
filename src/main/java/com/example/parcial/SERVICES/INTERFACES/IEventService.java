package com.example.parcial.SERVICES.INTERFACES;

import com.example.parcial.MODELENTITY.Event;

import java.util.List;

public interface IEventService {
    public List<Event> findAll();
    public Event save(Event event);
    public Event findById(Long id);
    public void deleteById(Long id);
}
