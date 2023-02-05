package com.yahya.mangschool.services;

import java.time.Instant;

public interface JavaDateFacade {
    String suffix = "T00:00:00.000Z";
   default public String suffixYMD(){
        return suffix;
    }
    public Instant fromYMD(String dateString);
}
