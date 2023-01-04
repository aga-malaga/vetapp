package com.agnieszka.reservationapp.vetapp.model.registration;

import javax.validation.constraints.NotEmpty;

public record RegistrationRequest(@NotEmpty(message = "Enter your firstname") String firstName,
                                  @NotEmpty(message = "Enter your lastName") String lastName,
                                  @NotEmpty(message = "Enter your username") String username,
                                  @NotEmpty(message = "Enter your email") String email,
                                  @NotEmpty(message = "Enter your password") String password) {

}
