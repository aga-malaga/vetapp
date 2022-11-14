package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.doctor.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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
        List<TimeSlot> slots = new ArrayList<>();
        int count = 0;
        while (start.isBefore(stop)) {
            final TimeSlot timeSlot = timeSlotRepository.save(
                    new TimeSlot(
                            LocalDateTime.of(date, start),
                            start.plusMinutes(intervaL),
                            doctor
                    ));
            start = start.plusMinutes(intervaL);
            count++;
        }
        return slots;
    }

    public List<TimeSlot> getSchedule(){
        return timeSlotRepository.findAll();
    }


}
