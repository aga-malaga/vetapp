package com.agnieszka.reservationapp.vetapp.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlDoctorRepository extends DoctorRepository, JpaRepository<Doctor, Long> {
}
