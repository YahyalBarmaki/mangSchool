package com.yahya.mangschool.services;

import com.yahya.mangschool.entity.Ecole;
import com.yahya.mangschool.repositories.EcoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoleService {

    private final EcoleRepository ecoleRepository;

    public EcoleService(EcoleRepository ecoleRepository) {
        this.ecoleRepository = ecoleRepository;
    }

    public Ecole saveEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    public Ecole updateEcole(Ecole ecole) {
        return ecoleRepository.save(ecole);
    }

    public List<Ecole> getAllEcoles() {
        return ecoleRepository.findAll();
    }

    public Ecole getEcoleById(Long id) {
        return ecoleRepository.findById(id).orElse(null);
    }

    public void deleteEcole(Long id) {
        ecoleRepository.deleteById(id);
    }

    public Ecole getEcoleByName(String name) {
        return ecoleRepository.findByName(name);
    }
}
