package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.model.registration.RegistrationRequest;
import com.agnieszka.reservationapp.vetapp.model.registration.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
class RegistrationController {

    private final RegistrationService registrationService;


    @PostMapping
    public ResponseEntity<AppUser> register(@RequestBody RegistrationRequest request) {
        final AppUser appUser = registrationService.register(request).getBody();
        if (appUser == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.created(URI.create("/" + appUser.getId())).body(appUser);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token){
        return registrationService.confirmToken(token);
    }

    }


