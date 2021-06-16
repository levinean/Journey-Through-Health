package com.example.journey_through_health.event;

import com.example.journey_through_health.image.Image;
import com.example.journey_through_health.note.Note;
import com.example.journey_through_health.patient.Patient;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@ToString
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
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
}
