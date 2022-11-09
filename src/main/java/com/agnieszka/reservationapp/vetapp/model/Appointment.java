package com.agnieszka.reservationapp.vetapp.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "timestamptz")
    private ZonedDateTime dateTime;

    @Column(columnDefinition = "TEXT")
    private String description;

//    @OneToOne
//    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "doctor_id"
    )
    private Doctor doctor;

//    private Client client;

    public Appointment() {
    }

    public Appointment(final Long id, final ZonedDateTime dateTime, final String description, final Doctor doctor) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.doctor = doctor;
    }
}

