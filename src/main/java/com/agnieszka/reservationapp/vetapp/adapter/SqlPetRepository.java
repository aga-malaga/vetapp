package com.agnieszka.reservationapp.vetapp.adapter;

import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.repository.PetRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlPetRepository extends PetRepository, JpaRepository<Pet, Long> {
}
