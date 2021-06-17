package com.example.journey_through_health.event;

import com.example.journey_through_health.image.Image;
import com.example.journey_through_health.note.Note;
import com.example.journey_through_health.patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Entity
@ToString
@Data
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "event")
    private List<Image> images;

    @OneToMany(mappedBy = "event")
    private List<Note> notes;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String hospital;

    @Column
    private String type;

    @Column
    private String priority;

    @CreatedDate
    @Column
    @JsonProperty("created_at")
    private Instant createdAt;
}
