package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.dto.EleveDTO;

import java.util.List;

public interface EcoleService {
     EcoleDTO save(EcoleDTO ecole);
     EcoleDTO findById(Long id);
     EcoleDTO update(Long id, EcoleDTO ecoleDTO);
     List<EcoleDTO> findAll();
     void deleteById(Long id);
}
