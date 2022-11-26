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
public class TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;


    public List<TimeSlot> createSchedule(LocalDate date, LocalTime start, LocalTime stop, String interval, Doctor doctor) {
        long intervaL = Long.parseLong(interval);
        ZoneId z = ZoneId.of("Europe/Warsaw");
        List<TimeSlot> slots = new ArrayList<>();
        int count = 0;
        while (start.isBefore(stop)) {
            final TimeSlot timeSlot = timeSlotRepository.save(
                    new TimeSlot(
                            ZonedDateTime.of(date, start, z),
                            ZonedDateTime.of(date, start, z).plus(intervaL, ChronoUnit.MINUTES),
                            doctor
                    ));
            slots.add(timeSlot);
            start = start.plusMinutes(intervaL);
            count++;
        }
        return slots;
    }

    public List<TimeSlot> getSchedule(){
        return timeSlotRepository.findAll();
    }


}
