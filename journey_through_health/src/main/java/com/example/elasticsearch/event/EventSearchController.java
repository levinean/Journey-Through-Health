package com.example.elasticsearch.event;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events/search")
@RequiredArgsConstructor
public class EventSearchController {
    private final EventSearchQuery eventSearchQuery;

    @GetMapping("{text}")
    public List<EventDocument> search(@PathVariable String text) {
        return eventSearchQuery.getEvents(text);
    }
}
