package com.yahya.mangschool.controller;

import com.yahya.mangschool.controller.api.EmploiDuTempsApi;
import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.services.EmploiDuTempsService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class EmploiDuTempsController implements EmploiDuTempsApi {
    private EmploiDuTempsService emploiDuTempsService;

    public EmploiDuTempsController(EmploiDuTempsService emploiDuTempsService) {
        this.emploiDuTempsService = emploiDuTempsService;
    }

    @Override
    public List<EmploiDuTempsDTO> findAll() {
        return emploiDuTempsService.findAll();
    }

    @Override
    public EmploiDuTempsDTO findById(Long id) {
        return emploiDuTempsService.findById(id);
    }

    @Override
    public EmploiDuTempsDTO update(Long id, EmploiDuTempsDTO emploiDuTempsDTO) {
        return emploiDuTempsService.update(id,emploiDuTempsDTO);
    }

    @Override
    public EmploiDuTempsDTO save(EmploiDuTempsDTO emploiDuTempsDTO) {
        return emploiDuTempsService.save(emploiDuTempsDTO);
    }

    @Override
    public void delete(Long id) {
        emploiDuTempsService.delete(id);
    }
}
