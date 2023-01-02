package com.agnieszka.reservationapp.vetapp.model;

import com.agnieszka.reservationapp.vetapp.model.appUser.AppUser;
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
            name = "appUser_id"
    )
    private AppUser appUser;

    public Appointment(final String description, final ZonedDateTime dateTime, final AppUser appUser) {
        this.description = description;
        this.dateTime = dateTime;
        this.appUser = appUser;
    }
}

