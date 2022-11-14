package com.agnieszka.reservationapp.vetapp.appointment;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

interface TimeSlotRepository {

    List<TimeSlot> findAll();

    List<TimeSlot> findAllById(Long id);

    TimeSlot save(TimeSlot slot);
}
