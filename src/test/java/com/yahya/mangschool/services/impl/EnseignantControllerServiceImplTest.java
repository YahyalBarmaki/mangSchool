package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.EnseignantService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EnseignantControllerServiceImplTest {
     @Autowired
    private EnseignantService enseignantService;

    public EnseignantControllerServiceImplTest(){}

    @Test
    public void testCreateEnseignant(){
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        enseignantDTO.setNom("Nom test");
        enseignantDTO.setPrenom("Prenom test");
        enseignantDTO.setAdresse("Adresse test");
        enseignantDTO.setTelephone("221761234455");

        EnseignantDTO result = enseignantService.save(enseignantDTO);
        assertNotNull(result);
        assertEquals(result.getNom(),enseignantDTO.getNom());
        assertEquals(result.getPrenom(),enseignantDTO.getPrenom());
        assertEquals(result.getAdresse(),enseignantDTO.getAdresse());
        assertEquals(result.getTelephone(),enseignantDTO.getTelephone());

    }

    @Test
    public void testUpdateEnseignant() {

        EnseignantDTO enseignantDTO = new EnseignantDTO();
        enseignantDTO.setNom("Nom test");
        enseignantDTO.setPrenom("Prenom test");
        enseignantDTO.setAdresse("Adresse test");
        enseignantDTO.setTelephone("221761234455");

        EnseignantDTO result = enseignantService.save(enseignantDTO);
        result.setNom("Nom update");
        result.setPrenom("Prenom update");
        result.setAdresse("Adresse update");
        result.setTelephone("221761234415");
        EnseignantDTO resultUpdate = enseignantService.update(result.getId(),result);

        assertNotNull(resultUpdate);
        assertEquals(resultUpdate.getNom(), result.getNom());
        assertEquals(resultUpdate.getPrenom(), result.getPrenom());
        assertEquals(resultUpdate.getAdresse(), result.getAdresse());
        assertEquals(resultUpdate.getTelephone(), result.getTelephone());

        assertNotEquals(enseignantDTO.getNom(), resultUpdate.getNom());
        assertNotEquals(enseignantDTO.getPrenom(), resultUpdate.getPrenom());
        assertNotEquals(enseignantDTO.getAdresse(), resultUpdate.getAdresse());
        assertNotEquals(enseignantDTO.getTelephone(), resultUpdate.getTelephone());



    }
    @Test
    public void testGetEnseignantById() {
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        enseignantDTO.setNom("Nom test");
        enseignantDTO.setPrenom("Prenom test");
        enseignantDTO.setAdresse("Adresse test");
        enseignantDTO.setTelephone("221761234455");

        EnseignantDTO result = enseignantService.save(enseignantDTO);
        EnseignantDTO findResult = enseignantService.findById(result.getId());

        assertNotNull(findResult);
        assertEquals(result.getNom(),findResult.getNom());
        assertEquals(result.getPrenom(),findResult.getPrenom());
        assertEquals(result.getAdresse(),findResult.getAdresse());
        assertEquals(result.getTelephone(),findResult.getTelephone());
    }

    @Test
    public void testGetAllEnseignant() {
        List<EnseignantDTO> enseignants = enseignantService.findAll();
        assertNotNull(enseignants);
        assertTrue(enseignants.size() > 0);
        assertFalse(enseignants.size() < 0);
    }

    @Test
    public void testDeleteEnseignat() {
        EnseignantDTO enseignantDTO = new EnseignantDTO();
        enseignantDTO.setNom("Nom test");
        enseignantDTO.setPrenom("Prenom test");
        enseignantDTO.setAdresse("Adresse test");
        enseignantDTO.setTelephone("221761234455");
        EnseignantDTO result = enseignantService.save(enseignantDTO);
        enseignantService.deleteById(result.getId());
        assertThrows(EntityNotFoundException.class,
                ()->{
                    enseignantService.findById(result.getId());
                });
    }


}