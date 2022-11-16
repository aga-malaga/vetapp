package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.client.Client;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(columnDefinition = "timestamp with time zone")
    private ZonedDateTime dateTime;
    //    @ManyToOne
//    @JoinColumn(
//            nullable = false,
//            name = "timeslot_id"
//    )
//    private TimeSlot timeSlot;
    @ManyToOne
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

