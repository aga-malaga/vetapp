package com.agnieszka.reservationapp.vetapp.appointment;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/appointment")
public class AppointmentController {

    private final TimeSlotService timeSlotService;

    public AppointmentController(final TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }




}
