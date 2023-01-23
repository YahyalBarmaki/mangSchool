package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClasseRepository extends JpaRepository<Classe,Long> {
    List<Classe> findByNiveau(String niveau);
}
