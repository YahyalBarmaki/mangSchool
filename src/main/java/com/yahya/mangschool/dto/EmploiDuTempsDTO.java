package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Setter
@Getter
public class EmploiDuTempsDTO {
    private Long id;
    private String jour;
    private Instant heureDebut;
    private Instant heureFin;
    private String nomEnseignant;
    private String nomMatiere;
   // private List<CreneauDTO> creneaux;
}
