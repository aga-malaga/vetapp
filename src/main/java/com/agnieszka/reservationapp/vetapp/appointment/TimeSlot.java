package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.doctor.Doctor;
import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "slots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "timestamp with time zone", name = "start_of_visit")
    private ZonedDateTime start;

    @Column(columnDefinition = "timestamp with time zone", name = "end_of_visit")
    private ZonedDateTime end;
    @OneToOne
    @JoinColumn(
            nullable = false,
            name = "doctor_id"
    )
    private Doctor doctor;

    private boolean booked = false;


    public TimeSlot(final ZonedDateTime start, final ZonedDateTime end, final Doctor doctor) {
        this.start = start;
        this.end = end;
        this.doctor = doctor;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TimeSlot timeSlot = (TimeSlot) o;
        return booked == timeSlot.booked && Objects.equals(id, timeSlot.id) && Objects.equals(start, timeSlot.start) && Objects.equals(end, timeSlot.end) && Objects.equals(doctor, timeSlot.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, doctor, booked);
    }
}
