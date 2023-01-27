package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EmploiDuTempsValidator {

    public static List<String> validate(EmploiDuTempsDTO emploiDuTempsDto) {
        List<String> errors = new ArrayList<>();

        if (emploiDuTempsDto == null) {
            errors.add("Veuillez renseigner le jour de l'emplois du temps");
            errors.add("Veuillez renseigner l'heureDebut de l'emplois du temps");
            errors.add("Veuillez renseigner l'heureFin de l'emplois du temps");
            errors.add("Veuillez renseigner le nom de l'enseignant de l'emplois du temps");
            errors.add("Veuillez renseigner le nom de la matiere de l'emplois du temps");
            return errors;
        }
        if (!StringUtils.hasLength(emploiDuTempsDto.getJour())) {
            errors.add("Veuillez renseigner le jour de l'emplois du temps");
        }
        if (!StringUtils.hasLength(String.valueOf(emploiDuTempsDto.getHeureDebut()))) {
            errors.add("Veuillez renseigner l'heureDebut de l'emplois du temps");
        }
        if (!StringUtils.hasLength(String.valueOf(emploiDuTempsDto.getHeureFin()))) {
            errors.add("Veuillez renseigner l'heureFin de l'emplois du temps");
        }
        if (!StringUtils.hasLength(emploiDuTempsDto.getNomEnseignant())) {
            errors.add("Veuillez renseigner le nom de l'enseignant de l'emplois du temps");
        } if (!StringUtils.hasLength(emploiDuTempsDto.getNomMatiere())) {
            errors.add("Veuillez renseigner le nom de la matiere de l'emplois du temps");
        }
        return errors;
    }
}
