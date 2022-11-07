package com.agnieszka.reservationapp.vetapp.model;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(columnDefinition = "timestamptz")
    private ZonedDateTime dateTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @OneToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

//    private Client client;

    public Appointment() {
    }

    public Appointment(final Integer id, final ZonedDateTime dateTime, final String description, final Doctor doctor) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.doctor = doctor;
    }
}

