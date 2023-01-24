package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.EcoleDTO;

import java.util.List;

public interface EcoleService {
     EcoleDTO save(EcoleDTO ecole);
     EcoleDTO findById(Long id);
     List<EcoleDTO> findAll();
     void deleteById(Long id);
}
