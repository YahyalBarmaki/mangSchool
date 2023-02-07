package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere,Long> {
}
