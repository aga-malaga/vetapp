package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.client.Client;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface AppointmentRepository {

    Appointment save(Appointment entity);

    Optional<Appointment> findByDateTime(ZonedDateTime dateTime);

    Optional<List<Appointment>> findByClient(Client client);

    Optional<Appointment> findById(Long id);


    List<Appointment> findAll();

    void deleteById(Long id);

    void delete(Appointment entity);


    @Transactional
    @Modifying
    @Query("UPDATE TimeSlot a " +
            "SET a.booked = TRUE " +
            "WHERE a.start = ?1")
    int bookTimeSlot(ZonedDateTime dateTime);
}
