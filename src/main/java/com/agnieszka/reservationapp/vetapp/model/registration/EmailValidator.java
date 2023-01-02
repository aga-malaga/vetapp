package com.agnieszka.reservationapp.vetapp.model.registration;

import org.springframework.stereotype.Service;

import java.util.function.Predicate;

import static org.apache.commons.validator.routines.EmailValidator.getInstance;

@Service
class EmailValidator implements Predicate<String> {
    @Override
    public boolean test(final String email) {
        final org.apache.commons.validator.routines.EmailValidator validator = getInstance();
        return validator.isValid(email);
    }
}
