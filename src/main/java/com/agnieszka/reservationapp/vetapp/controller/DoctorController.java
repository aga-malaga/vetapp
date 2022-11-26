package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import com.agnieszka.reservationapp.vetapp.model.Doctor;
import com.agnieszka.reservationapp.vetapp.repository.DoctorRepository;
import com.agnieszka.reservationapp.vetapp.service.DoctorService;
import com.agnieszka.reservationapp.vetapp.model.ScheduleRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/api/doctor")
class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);
    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;

    DoctorController(final DoctorRepository doctorRepository, final DoctorService doctorService) {
        this.doctorRepository = doctorRepository;
        this.doctorService = doctorService;
    }

    @GetMapping(params = {"!sort", "!page", "!size"})
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        logger.warn("Exposing all the doctors!");
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(Pageable p) {
        logger.info("Custom pageable");
        return ResponseEntity.ok(doctorRepository.findAll(p).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctor(@PathVariable Long id){
        if (!doctorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        return doctorRepository.findById(id)
                .map(ResponseEntity::ok)
                  .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody @Valid Doctor updatedDoctor){
        if (!doctorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        updatedDoctor.setId(id);
        doctorRepository.save(updatedDoctor);

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody @Valid Doctor doctor){
        Doctor created = doctorRepository.save(doctor);
        return ResponseEntity.created(URI.create("/" + created.getId())).body(created);
    }

    @PostMapping("/schedule")
    public List<TimeSlot> createSchedule(@RequestBody @Valid ScheduleRequest request){
        return doctorService.createSchedule(request);

    }
    @GetMapping("/schedule")
    public List<TimeSlot> getSchedule(){
        return doctorService.getSchedule();
    }


}