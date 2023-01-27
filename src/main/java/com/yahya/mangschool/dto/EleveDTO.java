package com.yahya.mangschool.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EleveDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private ClasseDTO classe;
    private List<NoteDTO> notes;
}
