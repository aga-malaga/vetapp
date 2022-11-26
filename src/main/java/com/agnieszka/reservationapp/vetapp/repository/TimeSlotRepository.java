package com.agnieszka.reservationapp.vetapp.repository;

import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public interface TimeSlotRepository {

    List<TimeSlot> findAll();

    TimeSlot findByStart(ZonedDateTime dateTime);

    List<TimeSlot> findAllById(Long id);

    TimeSlot save(TimeSlot slot);

    @Transactional
    @Modifying
    @Query("UPDATE TimeSlot a " +
            "SET a.booked = TRUE " +
            "WHERE a.start = ?1")
    int bookTimeSlot(ZonedDateTime dateTime);
}
