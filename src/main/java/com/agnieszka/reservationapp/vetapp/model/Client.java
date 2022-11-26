package com.agnieszka.reservationapp.vetapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet petGroup;

    public Client(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

}
