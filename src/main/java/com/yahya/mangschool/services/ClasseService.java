package com.yahya.mangschool.services;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.dto.EcoleDTO;

import java.util.List;

public interface ClasseService {
    List<ClasseDTO> findAll();
    ClasseDTO findById(Long id);
    ClasseDTO save(ClasseDTO classeDTO);
    ClasseDTO update(Long id, ClasseDTO classeDTO);
    void delete(Long id);
}

