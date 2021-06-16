package com.example.journey_through_health.note;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByEventId(Long eventId);
}
