package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class EmploiDuTempsDTO {
    private Long id;
    private EnseignantDTO enseignant;
    private List<CreneauEmploiDuTempsDTO> creneaux;
}
