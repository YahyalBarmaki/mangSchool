package com.yahya.mangschool.dto;

import java.util.List;

public class EnseignantDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private List<MatiereDTO> matieres;
    private List<EmploiDuTempsDTO> emploiDuTemps;
}
