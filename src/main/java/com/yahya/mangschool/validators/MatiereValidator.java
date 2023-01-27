package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.MatiereDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class MatiereValidator {

    public static List<String> validate(MatiereDTO matiereDto) {
        List<String> errors = new ArrayList<>();

        if (matiereDto == null) {
            errors.add("Veuillez renseigner le nom de la matiere");
            errors.add("Veuillez renseigner le coef de la matiere");
            errors.add("Veuillez renseigner le description de la matiere");
            errors.add("Veuillez renseigner l'enseignant qui enseigne cette matiere");
            errors.add("Veuillez renseigner la classe qui accepte cette matiere");
            return errors;
        }
        if (!StringUtils.hasLength(matiereDto.getNom())) {
            errors.add("Veuillez renseigner le nom de la classe");
        }
        if (!StringUtils.hasLength(matiereDto.getDescrip())) {
            errors.add("Veuillez renseigner le description de la matiere");
        }if (!StringUtils.hasLength(String.valueOf(matiereDto.getClasses()))) {
            errors.add("Veuillez renseigner la classe qui accepte cette matiere");
        }if (!StringUtils.hasLength(String.valueOf(matiereDto.getEnseignants()))) {
            errors.add("Veuillez renseigner la classe qui accepte cette matiere");
        }
        if (!StringUtils.hasLength(String.valueOf(matiereDto.getCoef()))) {
            errors.add("Veuillez renseigner le coef de la matiere");
        }
        return errors;
    }
}
