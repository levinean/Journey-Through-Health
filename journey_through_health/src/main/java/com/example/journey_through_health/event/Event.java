package com.example.journey_through_health.event;

import com.example.journey_through_health.image.Image;
import com.example.journey_through_health.note.Note;
import com.example.journey_through_health.patient.Patient;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@ToString
@Data
public class Event implements Serializable {
    private static final long serialVersionUID = -748956247024967638L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "patient_id", nullable = false)
    @JsonIgnore
    private Patient patient;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Image> images;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String hospital;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @CreatedDate
    @Column
    @JsonProperty("created_at")
    private Instant createdAt;

    public enum Type {
        appointment,
        surgery,
        exam,
        test,
        imaging;
    }

    public enum Priority {
        high,
        medium,
        low;
    }
}
