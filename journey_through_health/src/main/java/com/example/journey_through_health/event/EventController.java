package com.example.journey_through_health.event;

import com.example.journey_through_health.note.Note;
import com.example.journey_through_health.note.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {
    private final EventService eventService;
    private final NoteService noteService;

    @GetMapping("")
    public ResponseEntity<Object> getAllEvents() {
        return new ResponseEntity<>(eventService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<Event> getEvent(@PathVariable Long id) {
        Optional<Event> eventData = eventService.get(id);

        return eventData
                .map(event -> new ResponseEntity<>(event, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/{id}/notes")
    public ResponseEntity<Note> addNote(@RequestBody Note note, @PathVariable Long id) {
        Optional<Event> eventData = eventService.get(id);
        if (eventData.isPresent()) {
            note.setEvent(eventData.get());
            Note createdNote = noteService.create(note);
            return new ResponseEntity<>(createdNote, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
