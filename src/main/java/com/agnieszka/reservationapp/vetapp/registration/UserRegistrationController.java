package com.agnieszka.reservationapp.vetapp.registration;

import com.agnieszka.reservationapp.vetapp.appUser.AppUser;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(path = "api/registration")
@AllArgsConstructor
class UserRegistrationController {

    private RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<AppUser> register(@RequestBody RegistrationRequest request) {
        final AppUser appUser = registrationService.register(request);
        return ResponseEntity.created(URI.create("/" + appUser.getId())).body(appUser);
    }


}
