package com.agnieszka.reservationapp.vetapp.repository;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.model.Client;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppointmentRepository {

    Appointment save(Appointment entity);

    Optional<Appointment> findByDateTime(ZonedDateTime dateTime);

    Optional<List<Appointment>> findByClient(Client client);

    Optional<Appointment> findById(Long id);


    List<Appointment> findAll();

    void deleteById(Long id);


}
