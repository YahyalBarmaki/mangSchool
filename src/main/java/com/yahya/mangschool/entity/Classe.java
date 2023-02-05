package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classe")
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le nom de la classe doit compris entre 2 à 20 caratéteres")
    @Column(name = "nom")
    private String nom;
    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Size(min = 2,max=20,message = "Le niveau de la classe doit compris entre 2 à 20 caratéteres")
    @Column(name = "niveau")
    private String niveau;
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
        Classe classe = (Classe) o;
        return id != null && Objects.equals(id, classe.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
