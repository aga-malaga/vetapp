package com.agnieszka.reservationapp.vetapp.registration;

import com.agnieszka.reservationapp.vetapp.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.appUser.AppUserRole;
import com.agnieszka.reservationapp.vetapp.appUser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;


    public ResponseEntity<AppUser> register(final RegistrationRequest request) {
        final String email = request.getEmail();
        if (!emailValidator.test(email)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
            AppUser appUser = new AppUser
                    (
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword(),
                            AppUserRole.USER
                    );

        appUserService.signUpUser(appUser);


        return ResponseEntity.ok(appUser);
    }
}
