package com.example.journey_through_health.note;

import com.example.journey_through_health.note.Note;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
public class NoteController {

    @PostMapping()
    public void addNote(@RequestBody Note newNote) {
        System.out.println("Note added");
    }

    @PutMapping("/{id}")
    public void editNote(@RequestBody Note newNote,@PathVariable Long id) {
        System.out.println("Note edited");
    }

    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        System.out.println("Note deleted");
    }
}
