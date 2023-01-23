package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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
}
