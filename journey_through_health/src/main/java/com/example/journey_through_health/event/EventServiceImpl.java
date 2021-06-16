package com.example.journey_through_health.event;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl  implements EventService{
    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public void createEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public Optional<Event> getEvent(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<Event> getEvents() {
        return eventRepository.findAll();
    }
}
