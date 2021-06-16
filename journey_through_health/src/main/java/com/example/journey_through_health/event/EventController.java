package com.example.journey_through_health.event;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/events")
public class EventController {

    @GetMapping()
    public void getAllEvents(@RequestParam(value = "type", defaultValue = "all") String type, @RequestParam(value = "priority", defaultValue = "all") String priority) {
        System.out.println("Events gotten");
    }

    @GetMapping("/{id}")
    public void getEvent(@PathVariable Long id) {
        System.out.println("Event gotten");
    }

    @PostMapping()
    public void addEvent(@RequestBody Event newEvent) {
        System.out.println("Event added");
    }

    @PutMapping("/${id}")
    public void editEvent(@RequestBody Event newEvent,@PathVariable Long id) {
        System.out.println("Event edited");
    }

    @DeleteMapping ("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        System.out.println("Event deleted");
    }


}
