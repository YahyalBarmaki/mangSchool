package com.yahya.mangschool.services;
import com.yahya.mangschool.dto.EnseignantDTO;


import java.util.List;

public interface EnseignantService {

    EnseignantDTO save(EnseignantDTO ecole);
    EnseignantDTO findById(Long id);
    EnseignantDTO update(Long id, EnseignantDTO enseignantDTO);
    List<EnseignantDTO>findAll();
    void deleteById(Long id);
}
