package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.EmploiDuTemps;
import com.yahya.mangschool.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps,Long> {
    List<EmploiDuTemps> findByEnseignant(Enseignant enseignant);
}
