package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EleveDTO;
import java.util.List;


public interface EleveService {
    List<EleveDTO> findAll();
    EleveDTO findById(Long id);
    EleveDTO update(Long id, EleveDTO eleveDTO);
    EleveDTO save(EleveDTO eleveDTO);
    void delete(Long id);


}
