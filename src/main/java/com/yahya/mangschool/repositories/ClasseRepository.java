package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Classe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClasseRepository extends JpaRepository<Classe,Long> {
    List<Classe> findByNiveau(String niveau);
}
