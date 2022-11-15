package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.client.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Repository
@Transactional(readOnly = true)
public interface AppointmentRepository {

    Appointment save(Appointment entity);


    @Transactional
    @Modifying
    @Query("UPDATE TimeSlot a " +
            "SET a.booked = TRUE " +
            "WHERE a.start = ?1")
    int bookTimeSlot(LocalDateTime dateTime);
}
