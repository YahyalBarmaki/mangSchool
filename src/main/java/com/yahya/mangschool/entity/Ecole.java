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
    @NotNull(message = "Ce champ ne doit pas etre null")
    @NotBlank(message = "Ce champ est obligatoire")
    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le nom de la classe doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 5,max=20,message = "L\"adresse de l\"éléve doit compris entre 3 à 20 caratéteres")
    @Column(name = "adresse")
    private String adresse;

    //@NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Column(name = "telephone")
    //@Pattern(regexp = "^\\d{12}$")
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
