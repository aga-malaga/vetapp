package com.agnieszka.reservationapp.vetapp.adapter;

import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import com.agnieszka.reservationapp.vetapp.repository.TimeSlotRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SqlTimeSlotRepo extends TimeSlotRepository, JpaRepository<TimeSlot, Long> {
}
