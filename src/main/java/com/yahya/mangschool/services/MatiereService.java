package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.MatiereDTO;

import java.util.List;


public interface MatiereService {

    List<MatiereDTO> findAll();
    MatiereDTO findById(Long id);
    MatiereDTO save(MatiereDTO matiereDTO);
    MatiereDTO update(Long id, MatiereDTO matiereDTO);
    void delete(Long id);
}
