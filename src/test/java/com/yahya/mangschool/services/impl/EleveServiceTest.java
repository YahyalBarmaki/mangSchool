package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.entity.Ecole;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.EleveService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EleveServiceTest {

    @Autowired
    private EleveService eleveService;

    public EleveServiceTest(){}

    @Test
    public void testCreateEcole(){
        EleveDTO eleveDTO = new EleveDTO();
        eleveDTO.setNom("Nom test");
        eleveDTO.setPrenom("Prenoom test");
        eleveDTO.setTelephone("221761234455");
        eleveDTO.setAdresse("adresse Test");

        EleveDTO result = eleveService.save(eleveDTO);
        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals(eleveDTO.getNom(),result.getNom());
        assertEquals(eleveDTO.getPrenom(),result.getPrenom());
        assertEquals(eleveDTO.getAdresse(),result.getAdresse());
        assertEquals(eleveDTO.getTelephone(),result.getTelephone());
    }

    @Test
    public void testUpdateClasse(){
        EleveDTO eleveDTO = new EleveDTO();
        eleveDTO.setNom("Nom test");
        eleveDTO.setPrenom("Prenoom test");
        eleveDTO.setTelephone("221761234455");
        eleveDTO.setAdresse("adresse Test");

        EleveDTO saveEleve = eleveService.save(eleveDTO);
        saveEleve.setNom("Nom update");
        saveEleve.setPrenom("Prenoom update");
        saveEleve.setTelephone("221761234855");
        saveEleve.setAdresse("adresse update");

        EleveDTO result = eleveService.save(eleveDTO);
        EleveDTO resultUpdate = eleveService.update(result.getId(),result);

        assertNotNull(resultUpdate);
        assertEquals(result.getNom(),resultUpdate.getNom());
        assertEquals(result.getPrenom(),resultUpdate.getPrenom());
        assertEquals(result.getAdresse(),resultUpdate.getAdresse());
        assertEquals(result.getTelephone(),resultUpdate.getTelephone());
        assertNotEquals(resultUpdate.getNom(),saveEleve.getNom());
        assertNotEquals(resultUpdate.getPrenom(),saveEleve.getPrenom());
        assertNotEquals(resultUpdate.getAdresse(),saveEleve.getAdresse());
        assertNotEquals(resultUpdate.getTelephone(),saveEleve.getTelephone());
    }

    @Test
    public void testGetClasseById() {

        EleveDTO eleveDTO = new EleveDTO();
        eleveDTO.setNom("Nom test");
        eleveDTO.setPrenom("Prenoom test");
        eleveDTO.setTelephone("221761234455");
        eleveDTO.setAdresse("adresse Test");

        EleveDTO saveEleve = eleveService.save(eleveDTO);
        EleveDTO findEleve = eleveService.findById(saveEleve.getId());
        assertNotNull(findEleve);
        assertEquals(saveEleve.getNom(),findEleve.getNom());
        assertEquals(saveEleve.getPrenom(),findEleve.getPrenom());
        assertEquals(saveEleve.getAdresse(),findEleve.getAdresse());
        assertEquals(saveEleve.getTelephone(),findEleve.getTelephone());
    }

    @Test
    public void testGetAllClasses() {
        List<EleveDTO> eleveDTO = eleveService.findAll();
        assertNotNull(eleveDTO);
        assertTrue(eleveDTO.size() > 0);
        assertFalse(eleveDTO.size() < 0);
    }

    @Test
    public void testDeleteClasse() {
        EleveDTO eleveDTO = new EleveDTO();
        eleveDTO.setNom("Nom test");
        eleveDTO.setPrenom("Prenoom test");
        eleveDTO.setTelephone("221761234455");
        eleveDTO.setAdresse("adresse Test");
        EleveDTO saveEleve = eleveService.save(eleveDTO);
        eleveService.delete(saveEleve.getId());

        assertThrows(EntityNotFoundException.class,
                ()->{
                    eleveService.findById(saveEleve.getId());
                });
    };
}