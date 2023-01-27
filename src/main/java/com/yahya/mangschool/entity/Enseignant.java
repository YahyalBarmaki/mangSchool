package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;


import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "enseignant")
public class Enseignant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le nom de l\"éléve doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 3,max=20,message = "Le prénom de l\"éléve doit compris entre 3 à 20 caratéteres")
    @Column(name = "prenom")
    private String prenom;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 5,max=20,message = "L\"adresse de l\"éléve doit compris entre 3 à 20 caratéteres")
    @Column(name = "adresse")
    private String adresse;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 9,max=12,message = "Le numéro doit compris entre 9 à 12 caratéteres")
    @Column(name = "telephone")
    @Pattern(regexp = "^\\d{12}$",message="Numéro de téléphone invalide,veillez entrer des entiers")
    private String telephone;

    @ManyToOne
    @JoinColumn(name = "gestion_ecole_id")
    private GestionEcole gestionEcole;


    @ManyToMany()
    @ToString.Exclude
    private List<Matiere> matieres;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Enseignant that = (Enseignant) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
