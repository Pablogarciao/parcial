package com.example.parcial.SERVICES.INTERFACES;

import com.example.parcial.DTO.EventMediaDTO;
import com.example.parcial.MODELENTITY.EventMedia;

import java.util.List;

public interface IEventMediaService {
    public List<EventMedia> findAll();
    public EventMedia save(EventMedia eventMedia);
    public EventMedia findById(Long id);
    public void deleteById(Long id);

    public EventMedia createEventMedia (EventMediaDTO eventMediaDTO);
    public EventMedia editEventMedia(EventMediaDTO eventMediaDTO, Long id);
}
