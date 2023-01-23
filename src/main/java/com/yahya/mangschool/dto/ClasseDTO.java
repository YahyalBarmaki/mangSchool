package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClasseDTO {
    private Long id;
    private String nom;
    private List<EleveDTO> eleves;
    private List<MatiereDTO> matieres;
}
