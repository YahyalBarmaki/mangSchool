package com.yahya.mangschool.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "emploi_du_temps")
public class EmploiDuTemps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotEmpty
    private LocalTime heureDebut;
    @NotEmpty
    private LocalTime heureFin;
    @ManyToOne
    @JoinColumn(name = "classe_id")
    private Classe classe;

    @ManyToMany
    @JoinTable(name = "emploi_du_temps_matiere",
            joinColumns = @JoinColumn(name = "emploi_du_temps_id"),
            inverseJoinColumns = @JoinColumn(name = "matiere_id"))
    @ToString.Exclude
    private List<Matiere> matieres;

    @ManyToMany
    @JoinTable(name = "emploi_du_temps_enseignant",
            joinColumns = @JoinColumn(name = "emploi_du_temps_id"),
            inverseJoinColumns = @JoinColumn(name = "enseignant_id"))
    @ToString.Exclude
    private List<Enseignant> enseignant;

    @Column(name = "jour")
    private String jour;

    @OneToMany(mappedBy = "emploiDuTemps", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CreneauEmploiDuTemps> creneaux;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmploiDuTemps that = (EmploiDuTemps) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
