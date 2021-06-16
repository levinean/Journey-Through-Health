package com.example.journey_through_health.note;

import com.example.journey_through_health.event.Event;
import lombok.ToString;

import java.time.Instant;
import javax.persistence.*;

@Entity
@ToString
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @Column
    private String note;

    @Column
    private Instant date;
}
