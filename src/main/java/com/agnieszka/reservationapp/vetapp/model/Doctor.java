package com.agnieszka.reservationapp.vetapp.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MedicalSpecialty medicalSpecialty;


    public Doctor(final Long id, final String name, final String surname, final MedicalSpecialty medicalSpecialty) {
        this.name = name;
        this.surname = surname;
        this.medicalSpecialty = medicalSpecialty;
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        final Doctor doctor = (Doctor) o;
        return id != null && Objects.equals(id, doctor.id);
    }
}
