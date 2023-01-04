package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.repository.AppointmentRepository;
import com.agnieszka.reservationapp.vetapp.repository.TimeSlotRepository;
import com.agnieszka.reservationapp.vetapp.service.AppointmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/appointment")
class AppointmentController {

    private final AppointmentService appointmentService;

    private final AppointmentRepository appointmentRepository;

    private final TimeSlotRepository timeSlotRepository;

    @PostMapping
    public ResponseEntity<Appointment> makeAppointment(@RequestBody @Valid Appointment appointment) {
        if (timeSlotRepository.findByStart(appointment.getDateTime()).isBooked()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(appointmentService.makeAppointment(appointment));
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id) {
        appointmentRepository.deleteById(id);
    }

    @GetMapping
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }
}
