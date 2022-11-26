package com.agnieszka.reservationapp.vetapp.repository;

import com.agnieszka.reservationapp.vetapp.model.Client;
import com.agnieszka.reservationapp.vetapp.model.Pet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface ClientRepository {

    List<Client> findAll();

    Page<Client> findAll(Pageable page);

    Optional<Client> findById(Long id);

    boolean existsById(Long id);

    Client save(Client entity);

    void delete(Client entity);

}
