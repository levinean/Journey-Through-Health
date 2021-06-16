package com.example.journey_through_health.event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    void createEvent(Event event);
    Optional<Event> getEvent(Long id);
    List<Event> getEvents();
}
