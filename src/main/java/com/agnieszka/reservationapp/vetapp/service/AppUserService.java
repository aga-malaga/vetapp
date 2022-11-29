package com.agnieszka.reservationapp.vetapp.service;

import com.agnieszka.reservationapp.vetapp.model.appUser.AppUser;
import com.agnieszka.reservationapp.vetapp.model.appUser.AppUserRole;
import com.agnieszka.reservationapp.vetapp.model.token.ConfirmationToken;
import com.agnieszka.reservationapp.vetapp.model.token.ConfirmationTokenService;
import com.agnieszka.reservationapp.vetapp.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AppUserService implements UserDetailsService {


    private static final String USER_NOT_FOUND =
            "user with email %s not found";
    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;
    @Value("${spring.security.user.name}")
    private String adminUserName;
    @Value("${spring.security.user.password}")
    private String adminPassword;
    @Value("${spring.security.user.roles}")
    private String adminRole;
    public AppUserService(final AppUserRepository appUserRepository, final PasswordEncoder passwordEncoder, final ConfirmationTokenService confirmationTokenService) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.confirmationTokenService = confirmationTokenService;
    }

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        if (email.equals("admin")) {
            return User.builder().username(adminUserName).password(passwordEncoder.encode(adminPassword)).authorities(AppUserRole.ADMIN).build();
        }
        return appUserRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    @Transactional
    public String signUpUser(AppUser appUser) {
        final boolean present = appUserRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (present) {
            //todo check if attributes are the same and
            //todo if email not confirmed send confirmation email

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
        confirmationTokenService.saveConfirmationToken(confirmationToken);


        return token;
    }

    public int enableAppUser(String email) {
        return appUserRepository.enableAppUser(email);
    }
}
