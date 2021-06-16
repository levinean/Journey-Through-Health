package com.example.journey_through_health.image;

import com.example.journey_through_health.event.Event;
import lombok.ToString;

import javax.persistence.*;
import java.time.Instant;

@Entity
@ToString
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @Lob
    private Byte[] image;

    @Column
    private Instant date;
}
