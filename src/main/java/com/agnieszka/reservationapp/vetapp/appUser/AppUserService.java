package com.agnieszka.reservationapp.vetapp.appUser;

import com.agnieszka.reservationapp.vetapp.registration.token.ConfirmationToken;
import com.agnieszka.reservationapp.vetapp.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AppUserService implements UserDetailsService {

    private static final String USER_NOT_FOUND =
            "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;

    private final ConfirmationTokenService confirmationTokenService;
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUpUser(AppUser appUser){
        final boolean present = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (present){
            throw new IllegalStateException("This email already exists");
        }

        final String encodedPassword = passwordEncoder
                .encode(appUser.getPassword());

        appUser.setPassword(encodedPassword);

        appUserRepository.save(appUser);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                appUser
        );
        confirmationTokenService.sendConfirmationToken(confirmationToken);

// todo: send email
        return token;
    }
}
