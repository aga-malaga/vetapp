package com.agnieszka.reservationapp.vetapp.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository;

    public void sendConfirmationToken(ConfirmationToken token){
        confirmationTokenRepository.save(token);
    }
}
