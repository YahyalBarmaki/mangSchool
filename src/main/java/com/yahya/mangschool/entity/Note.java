package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.hibernate.Hibernate;


import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "eleve_id")
    private Eleve eleve;

    @ManyToOne
    @JoinColumn(name = "matiere_id")
    private Matiere matiere;

    @NotEmpty(message = "Ce champ ne doit pas etre vide")
    @Column(name = "note")
    private double note;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Note note = (Note) o;
        return id != null && Objects.equals(id, note.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
