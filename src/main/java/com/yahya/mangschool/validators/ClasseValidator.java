package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.ClasseDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClasseValidator {

    public static List<String> validate(ClasseDTO classeDto) {
        List<String> errors = new ArrayList<>();

        if (classeDto == null) {
            errors.add("Veuillez renseigner le nom de la classe");
            errors.add("Veuillez renseigner le niveau de la classe");
            return errors;
        }
        if (!StringUtils.hasLength(classeDto.getNom())) {
            errors.add("Veuillez renseigner le nom de la classe");
        }
        if (!StringUtils.hasLength(classeDto.getNiveau())) {
            errors.add("Veuillez renseigner le niveau de la classe");
        }
        return errors;
    }

}
