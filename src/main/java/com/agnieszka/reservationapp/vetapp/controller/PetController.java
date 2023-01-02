package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.model.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.repository.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.resources.request.PetDto;
import com.agnieszka.reservationapp.vetapp.service.PetService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/pet")
class PetController {

    private final AppUserRepository appUserRepository;

    private final PetService petService;


    @PostMapping("create")
    public ResponseEntity<Pet> createPet(@RequestBody PetDto petDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        log.info("username: " + currentUserName);
        AppUser appUser = appUserRepository.findByUsername(currentUserName).get();
        if (appUser == null){
            throw new UsernameNotFoundException("user not found");
        }
        return ResponseEntity.ok(petService.createPet(petDto, appUser));
    }
}
