package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.Doctor;
import com.agnieszka.reservationapp.vetapp.model.ScheduleRequest;
import com.agnieszka.reservationapp.vetapp.model.TimeSlot;
import com.agnieszka.reservationapp.vetapp.repository.DoctorRepository;
import com.agnieszka.reservationapp.vetapp.service.DoctorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/doctor")
class DoctorController {

    private final DoctorRepository doctorRepository;
    private final DoctorService doctorService;


    @GetMapping(params = {"!sort", "!page", "!size"})
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        log.warn("Exposing all the doctors!");
        return ResponseEntity.ok(doctorRepository.findAll());
    }

    @GetMapping
    public ResponseEntity<List<Doctor>> getAllDoctors(Pageable p) {
        log.info("Custom pageable");
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

    @PostMapping
    public ResponseEntity<Doctor> createDoctor(@RequestBody @Valid Doctor doctor){
        Doctor created = doctorRepository.save(doctor);
        return ResponseEntity.created(URI.create("/" + created.getId())).body(created);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Doctor> deleteDoctor(@PathVariable Long id){
        if (!doctorRepository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        doctorRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/schedule")
    public List<TimeSlot> getSchedule(){
        return doctorService.getSchedule();
    }
    @PostMapping("/schedule")
    public List<TimeSlot> createSchedule(@RequestBody @Valid ScheduleRequest request){
        return doctorService.createSchedule(request);

    }


}
