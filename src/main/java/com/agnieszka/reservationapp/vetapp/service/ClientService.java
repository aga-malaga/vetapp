package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.repository.AppointmentRepository;
import com.agnieszka.reservationapp.vetapp.repository.ClientRepository;
import com.agnieszka.reservationapp.vetapp.repository.TimeSlotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final AppointmentRepository appointmentRepository;

    private final TimeSlotRepository timeSlotRepository;

    ClientService(final ClientRepository clientRepository, final AppointmentRepository appointmentRepository, final TimeSlotRepository timeSlotRepository) {
        this.clientRepository = clientRepository;
        this.appointmentRepository = appointmentRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

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
                clientRepository.findById(request.getClient().getId()).orElseThrow()
        );
        appointment.setTimeSlot(timeSlotRepository.findByStart(request.getDateTime()));
        return appointmentRepository.save(appointment);
    }

}
