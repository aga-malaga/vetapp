package com.agnieszka.reservationapp.vetapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    @Enumerated(EnumType.STRING)
    private MedicalSpecialty medicalSpecialty;

    @OneToOne(mappedBy = "doctor")
    private Appointment appointment;

    public Doctor() {
    }

    Doctor(final Integer id, final String name, final String surname, final MedicalSpecialty medicalSpecialty) {
        this.name = name;
        this.surname = surname;
        this.medicalSpecialty = medicalSpecialty;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(final String surName) {
        this.surname = surName;
    }

    public MedicalSpecialty getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(final MedicalSpecialty medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Doctor doctor = (Doctor) o;
        return Objects.equals(id, doctor.id) && Objects.equals(name, doctor.name) && Objects.equals(surname, doctor.surname) && Objects.equals(medicalSpecialty, doctor.medicalSpecialty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, medicalSpecialty);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", medicalSpecialty=" + medicalSpecialty +
                '}';
    }
}
