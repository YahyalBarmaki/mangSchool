package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Classe;
import com.yahya.mangschool.entity.Eleve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EleveRepository extends JpaRepository<Eleve,Long> {
    List<Eleve> findByClasse(Classe classe);
}
