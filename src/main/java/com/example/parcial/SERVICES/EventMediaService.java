package com.example.parcial.SERVICES;

import com.example.parcial.DAO.IEventMediaDAO;
import com.example.parcial.MODELENTITY.EventMedia;
import com.example.parcial.SERVICES.INTERFACES.IEventMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventMediaService implements IEventMediaService {
    @Autowired
    private IEventMediaDAO eventMediaDAO;

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
}
