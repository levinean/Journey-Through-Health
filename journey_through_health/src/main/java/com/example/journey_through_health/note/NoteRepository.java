package com.example.journey_through_health.note;

import org.springframework.data.jpa.repository.JpaRepository;

interface NoteRepository extends JpaRepository<Note, Long> {
}
