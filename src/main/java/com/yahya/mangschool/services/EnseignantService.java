package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.entity.Enseignant;
import com.yahya.mangschool.repositories.EnseignantRepository;
import org.springframework.stereotype.Service;

import java.util.List;


public interface EnseignantService {

    EnseignantDTO save(EnseignantDTO ecole);
    EnseignantDTO findById(Long id);
    List<EnseignantDTO>findAll();
    void deleteById(Long id);
}
