package com.example.elasticsearch.event;

import com.example.journey_through_health.event.Event;

public interface EventSearchService {

    EventDocument create(Event event);

}
