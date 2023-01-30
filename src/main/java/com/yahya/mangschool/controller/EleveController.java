package com.yahya.mangschool.controller;

import com.yahya.mangschool.controller.api.EleveApi;
import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.services.EleveService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EleveController implements EleveApi {
     private EleveService eleveService;

    public EleveController(EleveService eleveService) {
        this.eleveService = eleveService;
    }

    @Override
    public List<EleveDTO> findAll() {
        return eleveService.findAll();
    }

    @Override
    public EleveDTO findById(Long id) {
        return eleveService.findById(id);
    }

    @Override
    public EleveDTO update(Long id, EleveDTO eleveDTO) {

        return  eleveService.update(id,eleveDTO);
    }

    @Override
    public EleveDTO save(EleveDTO eleveDTO) {
        return eleveService.save(eleveDTO);
    }

    @Override
    public void delete(Long id) {
        eleveService.delete(id);
    }
}
