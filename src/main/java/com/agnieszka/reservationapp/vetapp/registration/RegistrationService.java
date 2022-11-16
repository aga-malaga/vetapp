package com.agnieszka.reservationapp.vetapp.registration;

import com.agnieszka.reservationapp.vetapp.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.appUser.AppUserRole;
import com.agnieszka.reservationapp.vetapp.appUser.AppUserService;
import com.agnieszka.reservationapp.vetapp.client.Client;
import com.agnieszka.reservationapp.vetapp.client.ClientRepository;
import com.agnieszka.reservationapp.vetapp.client.Pet;
import com.agnieszka.reservationapp.vetapp.email.EmailSender;
import com.agnieszka.reservationapp.vetapp.registration.token.ConfirmationToken;
import com.agnieszka.reservationapp.vetapp.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    private final ClientRepository clientRepository;

    private final ConfirmationTokenService confirmationTokenService;

    private final EmailSender emailSender;


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
                        AppUserRole.CLIENT
                );

        final String token = appUserService.signUpUser(appUser);

        String link = "http://localhost:8080/api/registration/confirm?token=" + token;
        emailSender.send(
                request.getEmail(),
                emailSender.buildEmail(request.getFirstName(), link));

        Client client = new Client(
                appUser.getFirstName(),
                appUser.getLastName()
        );
        clientRepository.save(client);

        return ResponseEntity.ok(appUser);
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService
                .getToken(token)
                .orElseThrow(() ->
                        new IllegalStateException("token not found"));

        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("email already confirmed");
        }

        LocalDateTime expiredAt = confirmationToken.getExpiresAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("token expired");
        }

        confirmationTokenService.setConfirmedAt(token);
        appUserService.enableAppUser(
                confirmationToken.getAppUser().getEmail());

        return "confirmed";
    }
}
