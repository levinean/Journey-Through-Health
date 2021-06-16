package com.example.journey_through_health.note;

import com.example.journey_through_health.event.Event;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import javax.persistence.*;

@Entity
@ToString
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="event_id", nullable=false)
    private Event event;

    @Column
    private String note;

    @CreatedDate
    @Column
    private Instant createdAt;
}
