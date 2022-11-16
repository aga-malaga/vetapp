package com.agnieszka.reservationapp.vetapp.client;

import com.agnieszka.reservationapp.vetapp.appUser.AppUserRepository;
import com.agnieszka.reservationapp.vetapp.appointment.Appointment;
import com.agnieszka.reservationapp.vetapp.appointment.AppointmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/client")
class ClientController {

    private final ClientService clientService;

    private final ClientRepository clientRepository;

    private  final AppUserRepository appUserRepository;

    private final AppointmentRepository appointmentRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClient(@PathVariable Long id){
        return clientRepository.findById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @GetMapping
    public ResponseEntity<List<Client>> getClients(){
        return ResponseEntity.ok(clientRepository.findAll());
    }

    @PostMapping("/appointment")
    public ResponseEntity<Appointment> makeAppointment(@RequestBody @Valid Appointment appointment){
        return ResponseEntity.ok(clientService.makeAppointment(appointment));
    }

    @GetMapping("/appointments")
    public ResponseEntity<List<Appointment>> getAllAppointments(){
        return ResponseEntity.ok(appointmentRepository.findAll());
    }


}
