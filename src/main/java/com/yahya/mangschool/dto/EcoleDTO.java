package com.yahya.mangschool.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EcoleDTO {
    private Long id;
    private String nom;
    private String adresse;
    private String telephone;
    private String email;
    private String siteWeb;
}
