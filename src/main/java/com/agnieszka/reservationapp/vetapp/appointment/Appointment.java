package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
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

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "timeslot_id"
    )
    private TimeSlot timeSlot;

    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "client_id"
    )
    private Client client;

    public Appointment(final String description, final TimeSlot timeSlot, final Client client) {
        this.description = description;
        this.timeSlot = timeSlot;
        this.client = client;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Appointment that = (Appointment) o;
        return Objects.equals(id, that.id) && Objects.equals(description, that.description) && Objects.equals(timeSlot, that.timeSlot) && Objects.equals(client, that.client);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, timeSlot, client);
    }
}

