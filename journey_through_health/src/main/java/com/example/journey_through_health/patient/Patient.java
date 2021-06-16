package com.example.journey_through_health.patient;

import com.example.journey_through_health.event.Event;
import lombok.Data;
import lombok.ToString;
import javax.persistence.*;
import java.util.List;

@Entity
@ToString
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToMany(mappedBy = "patient")
    private List<Event> events;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String phoneNumber;
}
