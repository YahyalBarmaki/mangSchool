package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.EleveDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EleveValidator {

    public static List<String> validate(EleveDTO eleveDto) {
        List<String> errors = new ArrayList<>();

        if (eleveDto == null) {
            errors.add("Veuillez renseigner le nom de l'eleve");
            errors.add("Veuillez renseigner le prenom de l'eleve");
            errors.add("Veuillez renseigner le numéro telephone de l'élève");
            errors.add("Veuillez renseigner la classe de l'éleve");
            errors.add("Veuillez renseigner la note de l'éleve ");
            return errors;
        }
        if (!StringUtils.hasLength(eleveDto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'éleve");
        }
        if (!StringUtils.hasLength(eleveDto.getPrenom())) {
            errors.add("Veuillez renseigner le prenom de l'éleve");
        }
        if (!StringUtils.hasLength(eleveDto.getClasse().getNom())) {
            errors.add("Veuillez renseigner la classe de l'éleve");
        }
        if (!StringUtils.hasLength(eleveDto.getTelephone())) {
            errors.add("Veuillez renseigner le numéro téléphone de l'éleve");
        }
        if (!StringUtils.hasLength((CharSequence) eleveDto.getNotes())) {
            errors.add("Veuillez renseigner la note de l'éleve");
        }
        return errors;
    }
}
