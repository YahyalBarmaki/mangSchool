package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.MatiereService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class MatiereServiceImpTest {
    @Autowired
    private MatiereService matiereService;

    public MatiereServiceImpTest(){}

    @Test
    public void testCreateMatiere() {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setNom("matiere test");
        matiereDTO.setCoef(2);
        matiereDTO.setDescrip("Matiere de test");
        MatiereDTO resultMatiere = matiereService.save(matiereDTO);
        assertNotNull(resultMatiere);
        assertEquals(matiereDTO.getNom(),resultMatiere.getNom());
        assertEquals(matiereDTO.getCoef(),resultMatiere.getCoef());
        assertEquals(matiereDTO.getDescrip(),resultMatiere.getDescrip());

    }
    @Test
    public void testUpdateMatiere() {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setNom("matiere test");
        matiereDTO.setCoef(2);
        matiereDTO.setDescrip("Matiere de test");
        MatiereDTO resultMatiere = matiereService.save(matiereDTO);

        resultMatiere.setNom("matiere update");
        resultMatiere.setCoef(3);
        resultMatiere.setDescrip("Matiere d'update");

        MatiereDTO resultUpdate = matiereService.update(resultMatiere.getId(), resultMatiere);
        resultUpdate.setNom("matiere update");
        resultUpdate.setCoef(3);
        resultUpdate.setDescrip("Matiere d'update");

        assertNotNull(resultUpdate);
        assertEquals(resultMatiere.getNom(),resultUpdate.getNom());
        assertEquals(resultMatiere.getCoef(),resultUpdate.getCoef());
        assertEquals(resultMatiere.getDescrip(),resultUpdate.getDescrip());

        assertNotEquals(matiereDTO.getNom(),resultUpdate.getNom());
        assertNotEquals(matiereDTO.getCoef(),resultUpdate.getCoef());
        assertNotEquals(matiereDTO.getDescrip(),resultUpdate.getDescrip());

    }

    @Test
    public void testGetMatiereById() {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setNom("matiere test");
        matiereDTO.setCoef(2);
        matiereDTO.setDescrip("Matiere de test");

        MatiereDTO resultMatiere = matiereService.save(matiereDTO);
        MatiereDTO findMatière = matiereService.findById(resultMatiere.getId());

        assertNotNull(findMatière);
        assertEquals(resultMatiere.getNom(),findMatière.getNom());
        assertEquals(resultMatiere.getCoef(),findMatière.getCoef());
        assertEquals(resultMatiere.getDescrip(),findMatière.getDescrip());
    }

    @Test
    public void testGetAllMatière() {
        List<MatiereDTO> matiereDTOS = matiereService.findAll();
        assertNotNull(matiereDTOS);
        assertTrue(matiereDTOS.size() > 0);
        assertFalse(matiereDTOS.size() < 0);
    }

    @Test
    public void testDeleteClasse() {
        MatiereDTO matiereDTO = new MatiereDTO();
        matiereDTO.setNom("matiere test");
        matiereDTO.setCoef(2);
        matiereDTO.setDescrip("Matiere de test");
        MatiereDTO result = matiereService.save(matiereDTO);
        matiereService.delete(result.getId());
        assertThrows(EntityNotFoundException.class,
                ()->{
                    matiereService.findById(result.getId());
                });
    };

}