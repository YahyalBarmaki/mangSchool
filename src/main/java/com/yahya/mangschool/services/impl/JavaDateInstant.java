package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.services.JavaDateFacade;

import java.time.Instant;

public class JavaDateInstant implements JavaDateFacade {
    @Override
    public Instant fromYMD(String dateString) {
        return Instant.parse(dateString + suffixYMD());
    }
}
