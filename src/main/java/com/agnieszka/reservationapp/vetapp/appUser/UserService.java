package com.agnieszka.reservationapp.vetapp.appUser;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private static final String USER_NOT_FOUND =
            "user with email %s not found";
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, email)));
    }

    public String signUpUser(AppUser appUser){
        final boolean present = userRepository
                .findByEmail(appUser.getEmail())
                .isPresent();
        if (present){
            throw new IllegalStateException("This email already exists");
        }

        final String encode = passwordEncoder.encode(appUser.getPassword());
        appUser.setPassword(encode);

        userRepository.save(appUser);
        // TODO: send confirmation token

        return "password encoded";
    }
}
