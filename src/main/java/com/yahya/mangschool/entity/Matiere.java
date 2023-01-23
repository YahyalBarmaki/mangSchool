package com.yahya.mangschool.entity;

import jakarta.persistence.*;
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

    @Column(name = "nom")
    private String nom;

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
