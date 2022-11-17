package com.agnieszka.reservationapp.vetapp.client.pet;

import com.agnieszka.reservationapp.vetapp.client.Client;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public
class Pet {

    @Id
    private Long id;
    private String species;

    private String name;

    private String sex;

    private String age;

    @OneToOne
    @MapsId
    @JoinColumn(
            nullable = true,
            name = "owner_id"
    )
    private Client owner;

    public Pet(final String species, final String name, final String sex, final String age) {
        this.species = species;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, species, sex, age, owner);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(species, pet.species) && Objects.equals(sex, pet.sex) && Objects.equals(age, pet.age) && Objects.equals(owner, pet.owner);
    }
}
