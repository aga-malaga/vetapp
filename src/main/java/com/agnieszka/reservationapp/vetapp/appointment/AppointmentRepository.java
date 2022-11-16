package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.client.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppointmentRepository {

    Appointment save(Appointment entity);

    Optional<Appointment> findByDateTime(ZonedDateTime dateTime);

    Optional<List<Appointment>> findByClient(Client client);

    List<Appointment> findAll();


    @Transactional
    @Modifying
    @Query("UPDATE TimeSlot a " +
            "SET a.booked = TRUE " +
            "WHERE a.start = ?1")
    int bookTimeSlot(ZonedDateTime dateTime);
}
