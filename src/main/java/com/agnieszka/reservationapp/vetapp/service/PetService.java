package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.model.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.repository.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.repository.PetRepository;
import com.agnieszka.reservationapp.vetapp.resources.request.PetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Getter
@Service
public class PetService {

    private final AppointmentService appointmentService;
    private final PetRepository petRepository;
    private final AppUserRepository appUserRepository;

    @Transactional
    public Pet createPet(PetDto petDto, AppUser appUser) {

        Pet pet1 = new Pet(
                petDto.species(),
                petDto.name(),
                petDto.sex(),
                petDto.age()
        );

        appUser.getPets().add(pet1);
        appUserRepository.save(appUser);
        return petRepository.save(pet1);
    }


}
