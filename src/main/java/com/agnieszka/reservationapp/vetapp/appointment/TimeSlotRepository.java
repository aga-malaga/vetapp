package com.agnieszka.reservationapp.vetapp.appointment;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface TimeSlotRepository {

    List<TimeSlot> findAll();

    TimeSlot findByStart(ZonedDateTime dateTime);

    List<TimeSlot> findAllById(Long id);

    TimeSlot save(TimeSlot slot);
}
