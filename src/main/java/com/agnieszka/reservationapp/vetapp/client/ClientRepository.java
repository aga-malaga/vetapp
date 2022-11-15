package com.agnieszka.reservationapp.vetapp.client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ClientRepository  {

    List<Client> findAll();

    Page<Client> findAll(Pageable page);

    Optional<Client> findById(Long id);

    boolean existsById(Long id);

    Client save(Client entity);

    void delete(Client entity);

}
