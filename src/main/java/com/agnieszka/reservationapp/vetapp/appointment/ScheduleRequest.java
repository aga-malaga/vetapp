package com.agnieszka.reservationapp.vetapp.appointment;

import com.agnieszka.reservationapp.vetapp.doctor.Doctor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
@Getter
@Setter
public class ScheduleRequest {
    private LocalDate date;
    private LocalTime start;
    private LocalTime stop;
    private String interval;
    private  Doctor doctor;
}
