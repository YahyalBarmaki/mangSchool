package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Ecole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotBlank(message = "Ce champ est obligatoire nn")
    @Size(min = 2,max=200,message = "Le nom de la classe doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Size(min = 5,max=20,message = "L\"adresse de l\"école doit compris entre 3 à 20 caratéteres")
    @Column(name = "adresse")
    private String adresse;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Column(name = "telephone")
    @Size(min = 5,max=20,message = "L\"adresse de l\"éléve doit compris entre 3 à 20 caratéteres")
    @Pattern(regexp = "^(221)(77|76|70|75|78)([0-9]{7})$",message = "Le numéro doit etre au format 221 77|76|70|75|78 XXX XX XX")
    private String telephone;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")

    @Email(message = "Ce champ doit avoir un format XXX@YYY.xyz ")
    @Column(name = "email")
    private String email;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    private String siteWeb;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Ecole ecole = (Ecole) o;
        return id != null && Objects.equals(id, ecole.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
