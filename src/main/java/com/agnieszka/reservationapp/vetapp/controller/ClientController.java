package com.agnieszka.reservationapp.vetapp.controller;

import com.agnieszka.reservationapp.vetapp.model.Appointment;
import com.agnieszka.reservationapp.vetapp.model.Client;
import com.agnieszka.reservationapp.vetapp.model.Pet;
import com.agnieszka.reservationapp.vetapp.repository.*;
import com.agnieszka.reservationapp.vetapp.service.ClientService;
import com.agnieszka.reservationapp.vetapp.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.security.Principal;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/client")
class ClientController {

    private final ClientService clientService;

    private final ClientRepository clientRepository;

    private final AppUserRepository appUserRepository;

    private final AppointmentRepository appointmentRepository;

    private final TimeSlotRepository timeSlotRepository;

    private final PetService petService;

    private final PetRepository petRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id) {
        return clientRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Client>> getClients() {
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> makeAppointment(@RequestBody @Valid Appointment appointment) {
        if (timeSlotRepository.findByStart(appointment.getDateTime()).isBooked()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(clientService.makeAppointment(appointment));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments() {
        return ResponseEntity.ok(appointmentRepository.findAll());
    }

//    @PostMapping
//    public ResponseEntity<Pet> createPet(@RequestBody Pet pet, Principal principal) {
//        String username = principal.getName();
//        Pet created = petService.createPet(pet, username);
//        return ResponseEntity.created(URI.create("/" + created.getId())).body(created);
//    }
    @PostMapping
    public String createPet(@RequestBody Pet pet, Principal principal) {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        final String s = authentication.getPrincipal().toString();
        return s;

    }


}
