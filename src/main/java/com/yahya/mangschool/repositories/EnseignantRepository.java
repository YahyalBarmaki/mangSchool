package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnseignantRepository extends JpaRepository<Enseignant,Long> {
}
