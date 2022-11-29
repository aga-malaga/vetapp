package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.Client;
import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.repository.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.repository.ClientRepository;
import com.agnieszka.reservationapp.vetapp.repository.PetRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Getter
@Service
public class PetService {

    private final ClientService clientService;
    private final PetRepository petRepository;

    private final ClientRepository clientRepository;

    private final AppUserRepository appUserRepository;

    @Transactional
    public Pet createPet(Pet pet, Client client) {

        Pet pet1 = new Pet(
                pet.getSpecies(),
                pet.getName(),
                pet.getSex(),
                pet.getAge()
        );

        client.getPets().add(pet1);
        clientRepository.save(client);
        return petRepository.save(pet1);
    }


}
