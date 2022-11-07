package com.agnieszka.reservationapp.vetapp.registration;

import com.agnieszka.reservationapp.vetapp.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.appUser.UserRole;
import com.agnieszka.reservationapp.vetapp.appUser.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
class RegistrationService {

    private final UserService userService;
    private final EmailValidator emailValidator;


    public AppUser register(final RegistrationRequest request) {
        final String email = request.getEmail();
        if (!emailValidator.test(email)) {
            throw new IllegalArgumentException("Email address not valid");
        }
            AppUser appUser = new AppUser
                    (
                            request.getFirstName(),
                            request.getLastName(),
                            request.getEmail(),
                            request.getPassword(),
                            UserRole.USER
                    );

        userService.signUpUser(appUser);
        return appUser;
    }
}
