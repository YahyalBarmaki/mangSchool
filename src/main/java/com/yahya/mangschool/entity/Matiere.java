package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
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
@Table(name = "matiere")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le nom de l\"éléve doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;
    //@NotBlank(message = "Ce champ ne doit pas etre vide")
    private int coef;
    @NotBlank(message = "Ce champ ne doit pas etre vide")
    private String descrip;
    @ManyToMany(mappedBy = "matieres")
    @ToString.Exclude
    private List<Enseignant> enseignants;

    @ManyToMany(mappedBy = "matieres")
    @ToString.Exclude
    private List<Classe> classes;

    @ManyToOne
    @JoinColumn(name = "note_id")
    private Note note;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Matiere matiere = (Matiere) o;
        return id != null && Objects.equals(id, matiere.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
