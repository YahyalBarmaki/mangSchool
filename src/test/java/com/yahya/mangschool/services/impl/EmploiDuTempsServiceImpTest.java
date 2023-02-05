package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.services.EmploiDuTempsService;
import com.yahya.mangschool.services.JavaDateFacade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmploiDuTempsServiceImpTest {

    @Autowired
    private EmploiDuTempsService emploiDuTempsService;
    @Autowired
    private JavaDateFacade javaDateFacade;

    public EmploiDuTempsServiceImpTest(){}

    @Test
    public void testCreateEDT(){

        EmploiDuTempsDTO emploiDuTempsDTO = new EmploiDuTempsDTO();
        emploiDuTempsDTO.setJour("Jour test");
        emploiDuTempsDTO.setHeureDebut(javaDateFacade.fromYMD("2023-04-11"));
        emploiDuTempsDTO.setHeureFin(javaDateFacade.fromYMD("2023-04-12"));

        EmploiDuTempsDTO result = emploiDuTempsService.save(emploiDuTempsDTO);

        assertNotNull(result);
        assertEquals(emploiDuTempsDTO.getJour(),result.getJour());
        assertEquals(emploiDuTempsDTO.getHeureDebut(),result.getHeureDebut());
        assertEquals(emploiDuTempsDTO.getHeureFin(),result.getHeureFin());

    }
    @Test
    public void testUpdateEDT() {

        EmploiDuTempsDTO emploiDuTempsDTO = new EmploiDuTempsDTO();
        emploiDuTempsDTO.setJour("Jour test");
        emploiDuTempsDTO.setHeureDebut(javaDateFacade.fromYMD("2023-04-11"));
        emploiDuTempsDTO.setHeureFin(javaDateFacade.fromYMD("2023-04-12"));

        EmploiDuTempsDTO resultEDT = emploiDuTempsService.save(emploiDuTempsDTO);
        resultEDT.setJour("Jour update");
        resultEDT.setHeureDebut(javaDateFacade.fromYMD("2023-06-11"));
        resultEDT.setHeureFin(javaDateFacade.fromYMD("2023-06-12"));

        EmploiDuTempsDTO resultEDTupdate = emploiDuTempsService.update(resultEDT.getId(),resultEDT);

        assertNotNull(resultEDTupdate);
        assertEquals(resultEDTupdate.getJour(),resultEDT.getJour());
    }


    @Test
    public void testGetEDTeById() {
        EmploiDuTempsDTO emploiDuTempsDTO = new EmploiDuTempsDTO();
        emploiDuTempsDTO.setJour("Jour test");
        emploiDuTempsDTO.setHeureDebut(javaDateFacade.fromYMD("2023-04-11"));
        emploiDuTempsDTO.setHeureFin(javaDateFacade.fromYMD("2023-04-12"));

        EmploiDuTempsDTO result = emploiDuTempsService.save(emploiDuTempsDTO);
        EmploiDuTempsDTO findResult = emploiDuTempsService.findById(result.getId());

        assertNotNull(findResult);
        assertEquals(result.getJour(),findResult.getJour());
        //assertEquals(result.getHeureDebut(),findResult.getHeureDebut());
       // assertEquals(result.getHeureFin(),findResult.getHeureFin());
    }

    @Test
    public void testGetAllEDT() {
        List<EmploiDuTempsDTO> emploiDuTempsDTOS = emploiDuTempsService.findAll();
        assertNotNull(emploiDuTempsDTOS);
        assertTrue(emploiDuTempsDTOS.size() > 0);
        assertFalse(emploiDuTempsDTOS.size() < 0);
    }

    @Test
    public void testDeleteEDT() {
        EmploiDuTempsDTO emploiDuTempsDTO = new EmploiDuTempsDTO();
        emploiDuTempsDTO.setJour("Jour test");
        emploiDuTempsDTO.setHeureDebut(javaDateFacade.fromYMD("2023-04-11"));
        emploiDuTempsDTO.setHeureFin(javaDateFacade.fromYMD("2023-04-12"));

        EmploiDuTempsDTO result = emploiDuTempsService.save(emploiDuTempsDTO);
        emploiDuTempsService.delete(result.getId());
        assertThrows(EntityNotFoundException.class,
                ()->{
                    emploiDuTempsService.findById(result.getId());
                });
    };

}