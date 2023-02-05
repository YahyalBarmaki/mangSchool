package com.yahya.mangschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EleveDTO {

    private Long id;
    private String nom;
    private String prenom;
    private String telephone;
    private String adresse;
    private ClasseDTO classe;
    private NoteDTO notes;
}
