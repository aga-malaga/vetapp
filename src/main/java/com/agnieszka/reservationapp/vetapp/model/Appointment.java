package com.agnieszka.reservationapp.vetapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "timestamp with time zone")
    private ZonedDateTime dateTime;

    @OneToOne(cascade = CascadeType.REMOVE)
    @MapsId
    @JoinColumn(name = "id")
    private TimeSlot timeSlot;
    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(
            nullable = false,
            name = "client_id"
    )
    private Client client;

    public Appointment(final String description, final ZonedDateTime dateTime, final Client client) {
        this.description = description;
        this.dateTime = dateTime;
        this.client = client;
    }
}

