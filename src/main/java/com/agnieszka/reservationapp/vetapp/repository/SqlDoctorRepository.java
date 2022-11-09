package com.agnieszka.reservationapp.vetapp.repository;

import com.agnieszka.reservationapp.vetapp.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlDoctorRepository extends DoctorRepository, JpaRepository<Doctor, Long> {
}
