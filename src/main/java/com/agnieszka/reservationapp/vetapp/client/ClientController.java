package com.agnieszka.reservationapp.vetapp.client;

import com.agnieszka.reservationapp.vetapp.appUser.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.appointment.Appointment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(path = "/api/client")
class ClientController {

    private final ClientService clientService;

    private final ClientRepository clientRepository;

    private  final AppUserRepository appUserRepository;


    ClientController(final ClientService clientService, final ClientRepository clientRepository, final AppUserRepository appUserRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.appUserRepository = appUserRepository;
    }
    @PostMapping("/appointment")
    public void makeAppointment(Appointment appointment){
        clientService.makeAppointment(appointment);
    }

}
