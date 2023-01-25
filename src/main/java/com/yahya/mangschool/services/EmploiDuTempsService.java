package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.dto.EnseignantDTO;


import java.util.List;

public interface EmploiDuTempsService {

    List<EmploiDuTempsDTO> findAll();
    EmploiDuTempsDTO findById(Long id);
    EmploiDuTempsDTO update(Long id, EmploiDuTempsDTO emploiDuTempsDTO);
    EmploiDuTempsDTO save(EmploiDuTempsDTO emploiDuTempsDTO);
    void delete(Long id);
}
