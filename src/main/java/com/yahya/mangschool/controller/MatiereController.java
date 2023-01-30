package com.yahya.mangschool.controller;

import com.yahya.mangschool.controller.api.MatiereApi;
import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.services.MatiereService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MatiereController implements MatiereApi {
    private MatiereService matiereService;

    public MatiereController(MatiereService matiereService) {
        this.matiereService = matiereService;
    }

    @Override
    public List<MatiereDTO> findAll() {
        return matiereService.findAll();
    }

    @Override
    public MatiereDTO findById(Long id) {
        return matiereService.findById(id);
    }

    @Override
    public MatiereDTO save(MatiereDTO matiereDTO) {
        return matiereService.save(matiereDTO);
    }

    @Override
    public MatiereDTO update(Long id, MatiereDTO matiereDTO) {
        return matiereService.update(id,matiereDTO);
    }

    @Override
    public void delete(Long id) {
        matiereService.delete(id);
    }
}
