package com.agnieszka.reservationapp.vetapp.adapter;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.repository.AppointmentRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlAppointmentRepository extends AppointmentRepository, JpaRepository<Appointment, Long> {
}
