package com.yahya.mangschool.controller;

import com.yahya.mangschool.controller.api.EcoleApi;
import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.services.EcoleService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EcoleController implements EcoleApi {
    private EcoleService ecoleService;

    public EcoleController(EcoleService ecoleService) {
        this.ecoleService = ecoleService;
    }

    @Override
    public EcoleDTO save( EcoleDTO ecole) {
        return ecoleService.save(ecole);
    }

    @Override
    public EcoleDTO findById(Long id) {
        return ecoleService.findById(id);
    }

    @Override
    public EcoleDTO update(Long id, EcoleDTO ecoleDTO) {
        return ecoleService.update(id,ecoleDTO);
    }

    @Override
    public List<EcoleDTO> findAll() {
        return ecoleService.findAll();
    }

    @Override
    public void deleteById(Long id) {
    ecoleService.deleteById(id);
    }
}
