package com.agnieszka.reservationapp.vetapp.client;

import com.agnieszka.reservationapp.vetapp.appointment.Appointment;
import com.agnieszka.reservationapp.vetapp.appointment.AppointmentRepository;
import com.agnieszka.reservationapp.vetapp.appointment.TimeSlotRepository;
import org.springframework.stereotype.Service;

@Service
class ClientService {

    private final ClientRepository clientRepository;
    private final AppointmentRepository appointmentRepository;

    private final TimeSlotRepository timeSlotRepository;

    ClientService(final ClientRepository clientRepository, final AppointmentRepository appointmentRepository, final TimeSlotRepository timeSlotRepository) {
        this.clientRepository = clientRepository;
        this.appointmentRepository = appointmentRepository;
        this.timeSlotRepository = timeSlotRepository;
    }

    public void makeAppointment(Appointment appointment){
        appointmentRepository.bookTimeSlot(appointment.getTimeSlot().getStart());
        appointmentRepository.save(appointment);
    }
}
