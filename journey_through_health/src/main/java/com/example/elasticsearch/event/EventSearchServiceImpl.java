package com.example.elasticsearch.event;

import com.example.journey_through_health.event.Event;
import org.springframework.stereotype.Service;

@Service
public class EventSearchServiceImpl implements EventSearchService {
    private final EventSearchRepository eventSearchRepository;

    public EventSearchServiceImpl(EventSearchRepository eventSearchRepository) {
        this.eventSearchRepository = eventSearchRepository;
    }

    @Override
    public EventDocument create(Event event) {
        EventDocument eventDocument = EventDocument.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .hospital(event.getHospital())
                .createdAt(event.getCreatedAt())
                .type(EventDocument.Type.valueOf(event.getType().toString()))
                .priority(EventDocument.Priority.valueOf(event.getPriority().toString())).build();
        return eventSearchRepository.save(eventDocument);
    }
}

