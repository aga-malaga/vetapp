package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.Client;
import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.repository.ClientRepository;
import com.agnieszka.reservationapp.vetapp.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/pet")
class PetController {

    private final ClientRepository clientRepository;

    private final PetService petService;
    @PostMapping("create/{id}")
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet, @PathVariable Long id) {
        final Client client = clientRepository.findById(id).get();
        return ResponseEntity.ok(petService.createPet(pet, client));


    }

}
