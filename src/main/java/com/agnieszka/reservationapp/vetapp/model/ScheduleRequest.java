package com.agnieszka.reservationapp.vetapp.model;

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
    private Long doctor_id;
}
