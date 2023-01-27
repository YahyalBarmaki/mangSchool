package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NoteDTO {

    private Long id;
    private double valeur;
    private EleveDTO eleve;
    private MatiereDTO note;
}
