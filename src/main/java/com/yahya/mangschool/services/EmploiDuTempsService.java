package com.yahya.mangschool.services;

import com.yahya.mangschool.entity.EmploiDuTemps;
import com.yahya.mangschool.entity.Enseignant;
import com.yahya.mangschool.repositories.EmploiDuTempsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploiDuTempsService {

    private final EmploiDuTempsRepository emploiDuTempsRepository;

    public EmploiDuTempsService(EmploiDuTempsRepository emploiDuTempsRepository) {
        this.emploiDuTempsRepository = emploiDuTempsRepository;
    }


    public EmploiDuTemps saveEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsRepository.save(emploiDuTemps);
    }

    public EmploiDuTemps updateEmploiDuTemps(EmploiDuTemps emploiDuTemps) {
        return emploiDuTempsRepository.save(emploiDuTemps);
    }

    public List<EmploiDuTemps> getAllEmploiDuTemps() {
        return emploiDuTempsRepository.findAll();
    }

    public EmploiDuTemps getEmploiDuTempsById(Long id) {
        return emploiDuTempsRepository.findById(id).orElse(null);
    }

    public void deleteEmploiDuTemps(Long id) {
        emploiDuTempsRepository.deleteById(id);
    }

    public List<EmploiDuTemps> getEmploiDuTempsByEnseignant(Enseignant enseignant) {
        return emploiDuTempsRepository.findByEnseignant(enseignant);
    }
}
