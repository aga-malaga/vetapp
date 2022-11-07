package com.agnieszka.reservationapp.vetapp.model;

import java.util.Objects;

public class Client {


    private Long id;
    private String name;
    private String surname;

    public Client() {
    }

    public Client(final Long id, final String name, final String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(final String name) {
        this.name = name;
    }

    String getSurname() {
        return surname;
    }

    void setSurname(final String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(surname, client.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }
}
