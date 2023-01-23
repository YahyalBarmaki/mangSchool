package com.yahya.mangschool.services;

import com.yahya.mangschool.entity.Classe;
import com.yahya.mangschool.entity.Eleve;
import com.yahya.mangschool.repositories.EleveRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EleveService {

    private final EleveRepository eleveRepository;

    public EleveService(EleveRepository eleveRepository) {
        this.eleveRepository = eleveRepository;
    }

    public Eleve saveEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    public Eleve updateEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    public List<Eleve> getAllEleves() {
        return eleveRepository.findAll();
    }

    public Eleve getEleveById(Long id) {
        return eleveRepository.findById(id).orElse(null);
    }

    public void deleteEleve(Long id) {
        eleveRepository.deleteById(id);
    }

    public List<Eleve> getElevesByClasse(Classe classe) {
        return eleveRepository.findByClasse(classe);
    }
}
