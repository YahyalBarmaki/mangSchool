package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.EcoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EcoleServiceTest {

    @Autowired
    private EcoleService ecoleService;

    public EcoleServiceTest() {}

    @Test
    public void testCreateEcole() {
        EcoleDTO ecoleDTO = new EcoleDTO();
        ecoleDTO.setNom("Ecole Test");
        ecoleDTO.setAdresse("Adresse Test");
        ecoleDTO.setTelephone("221761234455");
        ecoleDTO.setEmail("test@xyz.com");
        ecoleDTO.setSiteWeb("www.test.com");
        EcoleDTO createdEcole = ecoleService.save(ecoleDTO);
        assertNotNull(createdEcole);
        assertNotNull(createdEcole.getId());
        assertEquals(ecoleDTO.getNom(), createdEcole.getNom());
        assertEquals(ecoleDTO.getAdresse(), createdEcole.getAdresse());
    }

    @Test
    public void testUpdateClasse() {
        EcoleDTO ecoleDTO = new EcoleDTO();

        ecoleDTO.setNom("Ecole Test");
        ecoleDTO.setAdresse("Adresse Test");
        ecoleDTO.setTelephone("221761234455");
        ecoleDTO.setEmail("test@xyz.com");
        ecoleDTO.setSiteWeb("www.test.com");

        EcoleDTO createdEcole = ecoleService.save(ecoleDTO);
        createdEcole.setNom("Ecole update");
        createdEcole.setAdresse("Adresse update");
        createdEcole.setTelephone("221761234405");
        createdEcole.setEmail("teste@xyz.com");
        createdEcole.setSiteWeb("www.test-test.com");

        EcoleDTO result = ecoleService.save(ecoleDTO);
        EcoleDTO resultUpdate = ecoleService.update(result.getId(),result);
        assertNotNull(resultUpdate);
        assertEquals(result.getNom(),resultUpdate.getNom());
        assertEquals(result.getAdresse(),resultUpdate.getAdresse());
        assertEquals(result.getTelephone(),resultUpdate.getTelephone());
        assertEquals(result.getEmail(),resultUpdate.getEmail());
        assertEquals(result.getSiteWeb(),resultUpdate.getSiteWeb());
        assertNotEquals(resultUpdate.getNom(),createdEcole.getNom());
        assertNotEquals(resultUpdate.getAdresse(),createdEcole.getAdresse());
        assertNotEquals(resultUpdate.getTelephone(),createdEcole.getTelephone());
        assertNotEquals(resultUpdate.getEmail(),createdEcole.getEmail());
    }

    @Test
    public void testGetClasseById() {
        EcoleDTO ecoleDTO = new EcoleDTO();
        ecoleDTO.setNom("Ecole Test");
        ecoleDTO.setAdresse("Adresse Test");
        ecoleDTO.setTelephone("221761234455");
        ecoleDTO.setEmail("test@xyz.com");
        ecoleDTO.setSiteWeb("www.test.com");
        EcoleDTO createdEcole = ecoleService.save(ecoleDTO);
        EcoleDTO findEcole = ecoleService.findById(createdEcole.getId());
        assertNotNull(findEcole);
        assertEquals(createdEcole.getNom(),findEcole.getNom());
        assertEquals(createdEcole.getAdresse(),findEcole.getAdresse());
        assertEquals(createdEcole.getTelephone(),findEcole.getTelephone());
        assertEquals(createdEcole.getEmail(),findEcole.getEmail());
        assertEquals(createdEcole.getSiteWeb(),findEcole.getSiteWeb());
    }

    @Test
    public void testGetAllClasses() {
        List<EcoleDTO> ecoleDTO = ecoleService.findAll();
        assertNotNull(ecoleDTO);
        assertTrue(ecoleDTO.size() > 0);
        assertFalse(ecoleDTO.size() < 0);
    }

    @Test
    public void testDeleteClasse() {
        EcoleDTO ecoleDTO = new EcoleDTO();
        ecoleDTO.setNom("Ecole Test");
        ecoleDTO.setAdresse("Adresse Test");
        ecoleDTO.setTelephone("221761234455");
        ecoleDTO.setEmail("test@xyz.com");
        ecoleDTO.setSiteWeb("www.test.com");
        EcoleDTO createdEcole = ecoleService.save(ecoleDTO);
        ecoleService.deleteById(createdEcole.getId());

        assertThrows(EntityNotFoundException.class,
                ()->{
                    ecoleService.findById(createdEcole.getId());
                });
    };

}