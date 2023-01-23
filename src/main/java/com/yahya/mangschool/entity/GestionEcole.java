package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "gestion_ecole")
public class GestionEcole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @OneToMany(mappedBy = "gestionEcole", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Classe> classes = new ArrayList<>();

    @OneToMany(mappedBy = "gestionEcole", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Enseignant> enseignants = new ArrayList<>();

    @OneToMany(mappedBy = "gestionEcole", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Eleve> eleves = new ArrayList<>();

    public List<Eleve> getEleves() {
        return eleves;
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public List<Enseignant> getEnseignants() {
        return enseignants;
    }

    public void setEnseignants(List<Enseignant> enseignants) {
        this.enseignants = enseignants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        GestionEcole that = (GestionEcole) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
