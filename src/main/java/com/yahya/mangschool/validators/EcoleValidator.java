package com.yahya.mangschool.validators;

import com.yahya.mangschool.dto.EcoleDTO;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EcoleValidator {

    public static List<String> validate(EcoleDTO ecoleDto) {
        List<String> errors = new ArrayList<>();

        if (ecoleDto == null) {
            errors.add("Veuillez renseigner le nom de l'école");
            errors.add("Veuillez renseigner l'adresse de l'école");
            errors.add("Veuillez renseigner le telephone de l'école");
            errors.add("Veuillez renseigner l'email de l'école");
            errors.add("Veuillez renseigner le siteWeb de l'école");
            return errors;
        }
        if (!StringUtils.hasLength(ecoleDto.getNom())) {
            errors.add("Veuillez renseigner le nom de l'école");
        }
        if (!StringUtils.hasLength(ecoleDto.getAdresse())) {
            errors.add("Veuillez renseigner l'adresse de l'école");
        }
        if (!StringUtils.hasLength(ecoleDto.getTelephone())) {
            errors.add("Veuillez renseigner le niveau de l'école");
        }
        if (!StringUtils.hasLength(ecoleDto.getEmail())) {
            errors.add("Veuillez renseigner le niveau de l'école");
        }
        if (!StringUtils.hasLength(ecoleDto.getSiteWeb())) {
            errors.add("Veuillez renseigner le niveau de l'école");
        }
        return errors;
    }
}
