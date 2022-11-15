package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.doctor.Doctor;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "slots")
public class TimeSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "timestamptz", name = "start_of_visit")
    private LocalDateTime start;

    @Column(columnDefinition = "time", name = "end_of_visit")
    private LocalTime end;
    @ManyToOne
    @JoinColumn(
            nullable = false,
            name = "doctor_id"
    )
    private Doctor doctor;

    private boolean booked = false;

    public TimeSlot(final LocalDateTime start, final LocalTime end, final Doctor doctor) {
        this.start = start;
        this.end = end;
        this.doctor = doctor;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final TimeSlot timeSlot = (TimeSlot) o;
        return Objects.equals(id, timeSlot.id) && Objects.equals(start, timeSlot.start) && Objects.equals(end, timeSlot.end) && Objects.equals(doctor, timeSlot.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, start, end, doctor);
    }
}
