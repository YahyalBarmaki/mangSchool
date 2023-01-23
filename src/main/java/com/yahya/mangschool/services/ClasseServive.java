package com.yahya.mangschool.services;

import com.yahya.mangschool.entity.Classe;
import com.yahya.mangschool.repositories.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClasseServive {


    private final ClasseRepository classeRepository;

    public ClasseServive(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    public Classe saveClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public Classe updateClasse(Classe classe) {
        return classeRepository.save(classe);
    }

    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    public Classe getClasseById(Long id) {
        return classeRepository.findById(id).orElse(null);
    }

    public void deleteClasse(Long id) {
        classeRepository.deleteById(id);
    }

    public List<Classe> getClassesByNiveau(String niveau) {
        return classeRepository.findByNiveau(niveau);
    }
}
