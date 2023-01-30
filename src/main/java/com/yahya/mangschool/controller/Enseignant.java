package com.yahya.mangschool.controller;

import com.yahya.mangschool.controller.api.EnseignantApi;
import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.services.EnseignantService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Enseignant implements EnseignantApi {
    private EnseignantService enseignantService;

    public Enseignant(EnseignantService enseignantService) {
        this.enseignantService = enseignantService;
    }

    @Override
    public EnseignantDTO save(EnseignantDTO ecole) {
        return enseignantService.save(ecole);
    }

    @Override
    public EnseignantDTO findById(Long id) {
        return enseignantService.findById(id);
    }

    @Override
    public EnseignantDTO update(Long id, EnseignantDTO enseignantDTO) {
        return enseignantService.update(id,enseignantDTO);
    }

    @Override
    public List<EnseignantDTO> findAll() {
        return enseignantService.findAll();
    }

    @Override
    public void deleteById(Long id) {
        enseignantService.deleteById(id);
    }
}
