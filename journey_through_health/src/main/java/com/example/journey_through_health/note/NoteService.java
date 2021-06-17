package com.example.journey_through_health.note;

import com.example.journey_through_health.JourneyCrud;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements JourneyCrud<Note> {
    private final NoteRepository noteRepo;

    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }

    public Note create(Note newNote) {
        newNote.setCreatedAt(Instant.now());
        return noteRepo.save(newNote);
    }

    public Optional<Note> delete(Long noteId) {
        Optional<Note> note = noteRepo.findById(noteId);
        noteRepo.deleteById(noteId);
        return note;
    }

    @Override
    public List<Note> listAll() {
        return null;
    }

    public Note edit(Long noteId, Note newNote) {
        Optional<Note> note = noteRepo.findById(noteId);
        noteRepo.deleteById(noteId);
        return noteRepo.save(newNote);
    }

    @Override
    public Optional<Note> get(Long id) {
        return Optional.empty();
    }
}
