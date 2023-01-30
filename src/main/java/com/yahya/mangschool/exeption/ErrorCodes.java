package com.yahya.mangschool.exeption;

public enum ErrorCodes {

    CLASSE_NOT_FOUND(1000),
    CLASSE_NOT_VALID(1001),
    ECOLE_NOT_FOUND(2000),
    ECOLE_NOT_VALID(2001),
    ELEVE_NOT_FOUND(3000),
    ELEVE_NOT_VALID(3001),
    EmploiDuTemps_NOT_FOUND(5000),
    EmploiDuTemps_NOT_VALID(5001),
    Enseignant_NOT_FOUND(6000),
    Enseignant_NOT_VALID(6001),
    MATIERE_NOT_FOUND(6000),
    MATIERE_NOT_VALID(6001),
    BAD_REQUEST(400),
    NOT_FOUND(404);

    private int code;

    ErrorCodes(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
