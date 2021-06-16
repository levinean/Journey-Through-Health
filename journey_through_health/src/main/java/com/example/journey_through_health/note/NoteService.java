package com.example.journey_through_health.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepo;

    public Note addNote(Note newNote) {
        newNote.setCreatedAt(Instant.now());
        return noteRepo.save(newNote);
    }

    public Note deleteNote(Long noteId) throws Exception {
        Optional<Note> note = noteRepo.findById(noteId);
        if (note.isEmpty()) {
            throw new Exception(String.format("No note with the id %d", noteId));
        }
        noteRepo.deleteById(noteId);
        return note.get();
    }

    public Note editNote(Long noteId, Note newNote) throws Exception {
        Optional<Note> note = noteRepo.findById(noteId);
        if (note.isEmpty()) {
            throw new Exception(String.format("No note with the id %d", noteId));
        }
        noteRepo.deleteById(noteId);
        return noteRepo.save(newNote);
    }
}
