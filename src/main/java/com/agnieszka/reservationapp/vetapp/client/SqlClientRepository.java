package com.agnieszka.reservationapp.vetapp.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface SqlClientRepository extends ClientRepository, JpaRepository<Client, Long> {
}
