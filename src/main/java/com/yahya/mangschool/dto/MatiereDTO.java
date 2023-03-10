package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MatiereDTO {
    private Long id;
    private String nom;
    private int coef;
    private String descrip;
    private EnseignantDTO enseignants;
    private ClasseDTO classes;

}
