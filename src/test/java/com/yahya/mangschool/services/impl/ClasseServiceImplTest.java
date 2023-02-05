package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.ClasseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClasseServiceImplTest {
    @Autowired
    private ClasseService classeService;

    public  ClasseServiceImplTest(){}
    @Test
    public void testCreateClasse() {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setNom("Classe 1");
        classeDTO.setNiveau("Niveau 1");
        ClasseDTO result = classeService.save(classeDTO);
        assertNotNull(result);
        assertEquals(result.getNom(), classeDTO.getNom());
        assertEquals(result.getNiveau(), classeDTO.getNiveau());
    }

    @Test
    public void testUpdateClasse() {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setNom("Classe 2");
        classeDTO.setNiveau("Niveau 2");

        ClasseDTO result = classeService.save(classeDTO);
        result.setNom("Classe updated");
        ClasseDTO updatedResult = classeService.update(result.getId(),result);
        assertNotNull(updatedResult);
        assertEquals(updatedResult.getNom(), result.getNom());
        assertEquals(updatedResult.getNiveau(), result.getNiveau());
        assertNotEquals(classeDTO.getNom(),updatedResult.getNom());
    }

    @Test
    public void testGetClasseById() {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setNom("Classe 3");
        classeDTO.setNiveau("Niveau 3");

        ClasseDTO result = classeService.save(classeDTO);
        ClasseDTO findResult = classeService.findById(result.getId());
        assertNotNull(findResult);
        assertEquals(findResult.getNom(), result.getNom());
        assertEquals(findResult.getNiveau(), result.getNiveau());
        assertEquals(findResult.getNom(),classeDTO.getNom());
    }
    @Test
    public void testGetAllClasses() {
        List<ClasseDTO> classes = classeService.findAll();
        assertNotNull(classes);
        assertTrue(classes.size() > 0);
        assertFalse(classes.size() < 0);
    }
    @Test
    public void testDeleteClasse() {
        ClasseDTO classeDTO = new ClasseDTO();
        classeDTO.setNom("Classe 4");
        classeDTO.setNiveau("Niveau 4");
        ClasseDTO result = classeService.save(classeDTO);
        classeService.delete(result.getId());
        assertThrows(EntityNotFoundException.class,
                ()->{
                    classeService.findById(result.getId());
                });
    };

}