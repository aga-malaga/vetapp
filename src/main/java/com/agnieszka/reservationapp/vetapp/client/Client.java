package com.agnieszka.reservationapp.vetapp.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Objects;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;

//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(
//            nullable = true,
//            name = "pet_id"
//    )
//    private Pet pet;

    public Client(final String name, final String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Client client = (Client) o;
        return Objects.equals(id, client.id) && Objects.equals(name, client.name) && Objects.equals(surname, client.surname);
    }
}
