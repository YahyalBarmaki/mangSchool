package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.entity.Matiere;
import com.yahya.mangschool.repositories.MatiereRepository;
import com.yahya.mangschool.services.MatiereService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class MatiereServiceImp implements MatiereService {

    final private MatiereRepository matiereRepository;
    final private ModelMapper modelMapper;

    public MatiereServiceImp(MatiereRepository matiereRepository, ModelMapper modelMapper) {
        this.matiereRepository = matiereRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<MatiereDTO> findAll() {
        List<Matiere> matieres = matiereRepository.findAll();
        return matieres.stream()
                .map(matiere -> modelMapper.map(matiere, MatiereDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public MatiereDTO findById(Long id) {
        Optional<Matiere> matiere = matiereRepository.findById(id);
        return matiere.map(mat -> modelMapper.map(mat, MatiereDTO.class)).orElse(null);
    }

    @Override
    public MatiereDTO save(MatiereDTO matiereDTO) {
        Matiere matiere = modelMapper.map(matiereDTO, Matiere.class);
        matiere = matiereRepository.save(matiere);
        return modelMapper.map(matiere, MatiereDTO.class);
    }

    @Override
    public MatiereDTO update(Long id, MatiereDTO matiereDTO) {
        Optional<Matiere> matiere = matiereRepository.findById(id);
        if (matiere.isEmpty()) {
            return null;
        }
        modelMapper.map(matiereDTO, matiere.get());
        matiereRepository.save(matiere.get());
        return modelMapper.map(matiere.get(), MatiereDTO.class);
    }

    @Override
    public void delete(Long id) {
        matiereRepository.deleteById(id);
    }
}
