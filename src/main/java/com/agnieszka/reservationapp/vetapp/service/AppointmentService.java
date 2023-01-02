package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.repository.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.repository.AppointmentRepository;
import com.agnieszka.reservationapp.vetapp.repository.TimeSlotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final AppUserRepository appUserRepository;



    @Transactional
    public Appointment makeAppointment(Appointment request){
        final boolean present = appointmentRepository
                .findByDateTime(request.getDateTime())
                .isPresent();

        if (present) {
            throw new IllegalStateException("This appointment is already booked");
        }


        timeSlotRepository.bookTimeSlot(request.getDateTime());
        Appointment appointment = new Appointment(
                request.getDescription(),
                request.getDateTime(),
                appUserRepository.findById(request.getAppUser().getId()).orElseThrow()
        );
        appointment.setTimeSlot(timeSlotRepository.findByStart(request.getDateTime()));
        return appointmentRepository.save(appointment);
    }

}
