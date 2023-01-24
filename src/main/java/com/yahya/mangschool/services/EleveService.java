package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.entity.Eleve;

import java.util.List;


public interface EleveService {
    List<EleveDTO> findAll();
    EleveDTO findById(Long id);
    EleveDTO save(EleveDTO eleveDTO);
    void delete(Long id);


}
