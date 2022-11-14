package com.agnieszka.reservationapp.vetapp.appointment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTimeSlotRepo extends TimeSlotRepository, JpaRepository<TimeSlot, Long> {
}
