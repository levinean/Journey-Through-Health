package com.example.journey_through_health.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/notes")
public class NoteController {

    @Autowired
    private NoteService service;

    @PostMapping()
    public Note addNote(@RequestBody Note newNote) {
        return service.addNote(newNote);
    }

    @PutMapping("/{id}")
    public Note editNote(@RequestBody Note newNote, @PathVariable Long id) throws Exception {
        return service.editNote(id, newNote);
    }

    @DeleteMapping("/{id}")
    public Note deleteNote(@PathVariable Long id) throws Exception {
        return service.deleteNote(id);
    }
}
