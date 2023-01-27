package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.EnseignantDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EnseignantValidator {

    public static List<String> validate(EnseignantDTO enseignantDto) {
        List<String> errors = new ArrayList<>();

        if (enseignantDto == null) {
            errors.add("Veuillez renseigner le nom de l'enseignant");
            errors.add("Veuillez renseigner le prenom de l'enseignant");
            errors.add("Veuillez renseigner l'adresse'u de l'enseignant");
            errors.add("Veuillez renseigner le numéro telephone de l'enseignant");
            errors.add("Veuillez renseigner le(s) matiere(s) que l'enseignant enseigne");
            errors.add("Veuillez renseigner l'emplois du tempsque l'enseignant a");
            return errors;
        }
        if (!StringUtils.hasLength(enseignantDto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'enseignant");
        }
        if (!StringUtils.hasLength(enseignantDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom de l'enseignant");
        }
        if (!StringUtils.hasLength(enseignantDto.getTelephone())) {
            errors.add("Veuillez renseigner le numéro telephone de l'enseignant");
        }
        if (!StringUtils.hasLength(enseignantDto.getAdresse())) {
            errors.add("Veuillez renseigner l'adresse'u de l'enseignant");
        }
        if (!StringUtils.hasLength((CharSequence) enseignantDto.getEmploiDuTemps())) {
            errors.add("Veuillez renseigner l'emplois du tempsque l'enseignant a");
        }
        if (!StringUtils.hasLength((CharSequence) enseignantDto.getMatieres())) {
            errors.add("Veuillez renseigner le(s) matiere(s) que l'enseignant enseigne");

        }
        return errors;
    }
}
