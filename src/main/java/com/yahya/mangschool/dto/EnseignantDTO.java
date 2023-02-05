package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EnseignantDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private MatiereDTO matieres;
    private EmploiDuTempsDTO emploiDuTemps;
}
