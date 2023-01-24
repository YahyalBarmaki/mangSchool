package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Setter
@Getter
public class EmploiDuTempsDTO {
    private Long id;
    private String jour;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private String nomEnseignant;
    private String nomMatiere;
}
