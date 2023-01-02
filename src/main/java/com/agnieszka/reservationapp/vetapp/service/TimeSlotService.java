package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.Doctor;
import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import com.agnieszka.reservationapp.vetapp.repository.TimeSlotRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;


    List<TimeSlot> createSchedule(LocalDate date, LocalTime start, LocalTime stop, String interval, Doctor doctor) {
        long intervaL = Long.parseLong(interval);
        ZoneId z = ZoneId.of("Europe/Warsaw");
        List<TimeSlot> slots = new ArrayList<>();
        while (start.isBefore(stop)) {
            final TimeSlot timeSlot = timeSlotRepository.save(
                    new TimeSlot(
                            ZonedDateTime.of(date, start, z),
                            ZonedDateTime.of(date, start, z).plus(intervaL, ChronoUnit.MINUTES),
                            doctor
                    ));
            slots.add(timeSlot);
            start = start.plusMinutes(intervaL);
        }
        return slots;
    }

    List<TimeSlot> getSchedule(){
        return timeSlotRepository.findAll();
    }


}
