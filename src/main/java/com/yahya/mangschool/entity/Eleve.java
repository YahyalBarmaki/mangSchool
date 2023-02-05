package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;


import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "eleve")
public class Eleve {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le nom de l\"éléve doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Size(min = 3,max=20,message = "Le prénom de l'éléve doit compris entre 3 à 20 caratéteres")
    @Column(name = "prenom")
    private String prenom;



    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Size(min = 5,max=20,message = "L'adresse de l'éléve doit compris entre 3 à 20 caratéteres")
    @Column(name = "adresse")
    private String adresse;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Column(name = "telephone")
    @Pattern(regexp = "^(221)(77|76|70|75|78)([0-9]{7})$",message = "Le numéro doit etre au format 221 77|76|70|75|78 XXX XX XX")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Eleve eleve = (Eleve) o;
        return id != null && Objects.equals(id, eleve.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
