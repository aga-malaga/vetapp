package com.agnieszka.reservationapp.vetapp.repository;

import com.agnieszka.reservationapp.vetapp.model.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository  {
    List<Doctor> findAll();

    Page<Doctor> findAll(Pageable page);

    Optional<Doctor> findById(Long id);

    boolean existsById(Long id);
    Doctor save(Doctor entity);

    void deleteById(Long id);
}
