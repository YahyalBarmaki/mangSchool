package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GestionEcoleDTO {

    private Long id;
    private List<ClasseDTO> classes;
    private List<EnseignantDTO> enseignants;
    private List<EleveDTO> eleves;
    private List<MatiereDTO> matieres;
}
