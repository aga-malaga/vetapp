package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.ScheduleRequest;
import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import com.agnieszka.reservationapp.vetapp.repository.DoctorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    private final TimeSlotService timeSlotService;

    public List<TimeSlot> createSchedule(ScheduleRequest request){
        return timeSlotService.createSchedule(
                request.getDate(),
                request.getStart(),
                request.getStop(),
                request.getInterval(),
                doctorRepository.findById(request.getDoctor_id()).orElseThrow(IllegalArgumentException::new)
        );
    }

    public List<TimeSlot> getSchedule(){
        return timeSlotService.getSchedule();
    }

}
