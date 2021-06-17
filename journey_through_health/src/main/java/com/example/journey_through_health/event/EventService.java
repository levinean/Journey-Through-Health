package com.example.journey_through_health.event;

import com.example.journey_through_health.JourneyCrud;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class EventService implements JourneyCrud<Event> {
    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Event create(Event event) {
        event.setCreatedAt(Instant.now());
        return eventRepository.save(event);
    }

    @Override
    public Event edit(Long id, Event o) {
        return null;
    }

    @Override
    public Optional<Event> get(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public Optional<Event> delete(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }
}
