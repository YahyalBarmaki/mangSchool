package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatiereDTO {
    private Long id;
    private String nom;
    private List<EnseignantDTO> enseignants;
    private List<ClasseDTO> classes;
}
