package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.doctor.Doctor;
import com.agnieszka.reservationapp.vetapp.model.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "timestamptz")
    private ZonedDateTime dateTime;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "doctor_id"
    )
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "client_id"
    )
    private Client client;

    public Appointment(
            final Long id,
            final ZonedDateTime dateTime,
            final String description,
            final Doctor doctor,
            final Client client) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.doctor = doctor;
        this.client = client;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(dateTime, that.dateTime) && Objects.equals(description, that.description) && Objects.equals(doctor, that.doctor) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dateTime, description, doctor, client);
    }
}

