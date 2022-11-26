package com.agnieszka.reservationapp.vetapp.adapter;

import com.agnieszka.reservationapp.vetapp.model.Doctor;
import com.agnieszka.reservationapp.vetapp.repository.DoctorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlDoctorRepository extends DoctorRepository, JpaRepository<Doctor, Long> {
}
