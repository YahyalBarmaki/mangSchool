package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;


import java.util.List;

public interface EmploiDuTempsService {

    List<EmploiDuTempsDTO> findAll();
    EmploiDuTempsDTO findById(Long id);
    EmploiDuTempsDTO save(EmploiDuTempsDTO emploiDuTempsDTO);
    void delete(Long id);
}
