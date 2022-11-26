package com.agnieszka.reservationapp.vetapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public
class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String species;

    private String name;

    private String sex;

    private String age;




    public Pet(final String species, final String name, final String sex, final String age) {
        this.species = species;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Pet pet = (Pet) o;
        return Objects.equals(id, pet.id) && Objects.equals(species, pet.species) && Objects.equals(name, pet.name) && Objects.equals(sex, pet.sex) && Objects.equals(age, pet.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, species, name, sex, age);
    }
}
