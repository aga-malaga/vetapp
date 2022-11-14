package com.agnieszka.reservationapp.vetapp.doctor;

import com.agnieszka.reservationapp.vetapp.appointment.ScheduleRequest;
import com.agnieszka.reservationapp.vetapp.appointment.TimeSlot;
import com.agnieszka.reservationapp.vetapp.appointment.TimeSlotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
class DoctorService {

    private final DoctorRepository doctorRepository;

    private final TimeSlotService timeSlotService;


    DoctorService(final DoctorRepository doctorRepository, final TimeSlotService timeSlotService) {
        this.doctorRepository = doctorRepository;
        this.timeSlotService = timeSlotService;
    }

    public List<Doctor> getDoctors(){
        return doctorRepository.findAll();
    }

    public Doctor getDoctor(Long id){
        return doctorRepository.findById(id).orElseThrow(IllegalStateException::new);
    }

    public Doctor createDoctor(Doctor doctor){
        final Doctor created = new Doctor(
                doctor.getId(),
                doctor.getName(),
                doctor.getSurname(),
                doctor.getMedicalSpecialty()
        );
        return doctorRepository.save(created);
    }

    public Doctor updateDoctor(Doctor doctor){
        if (!doctorRepository.existsById(doctor.getId())){
            throw new IllegalStateException("This doctor doesn't exist");
        }
        doctor.setId(doctor.getId());
        return doctorRepository.save(doctor);
    }

    public List<TimeSlot> createSchedule(ScheduleRequest request){
        return timeSlotService.createSchedule(
                request.getDate(),
                request.getStart(),
                request.getStop(),
                request.getInterval(),
                request.getDoctor()
        );
    }

    public List<TimeSlot> getSchedule(){
        return timeSlotService.getSchedule();
    }

}
