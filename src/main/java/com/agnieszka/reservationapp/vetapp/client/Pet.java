package com.agnieszka.reservationapp.vetapp.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String species;

    private String name;

    private String sex;

    private String age;

    @ManyToOne
    @JoinColumn(
            nullable = true,
            name = "owner_id"
    )
    private Client owner;

    public Pet(final Long id, final String species, final String sex, final String age, final Client owner) {
        this.id = id;
        this.species = species;
        this.sex = sex;
        this.age = age;
        this.owner = owner;
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
