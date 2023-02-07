package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.EmploiDuTemps;
import com.yahya.mangschool.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmploiDuTempsRepository extends JpaRepository<EmploiDuTemps,Long> {
    List<EmploiDuTemps> findByEnseignant(Enseignant enseignant);
}
