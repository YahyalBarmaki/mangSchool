package com.yahya.mangschool.repositories;

import com.yahya.mangschool.entity.Ecole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EcoleRepository  extends JpaRepository<Ecole,Long> {
    Ecole findByNom(String name);
}
