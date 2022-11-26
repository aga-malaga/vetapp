package com.agnieszka.reservationapp.vetapp.adapter;

import com.agnieszka.reservationapp.vetapp.model.Client;
import com.agnieszka.reservationapp.vetapp.repository.ClientRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Long> {
}
