package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.entity.Eleve;
import com.yahya.mangschool.entity.Enseignant;
import com.yahya.mangschool.repositories.EnseignantRepository;
import com.yahya.mangschool.services.EnseignantService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnseignantServiceImpl implements EnseignantService {
    final private EnseignantRepository enseignantRepository;
    final private ModelMapper modelMapper;

    public EnseignantServiceImpl(EnseignantRepository enseignantRepository, ModelMapper modelMapper) {
        this.enseignantRepository = enseignantRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EnseignantDTO save(EnseignantDTO enseignantDTO) {
        Enseignant enseignant = modelMapper.map(enseignantDTO,Enseignant.class);
        enseignantRepository.save(enseignant);
        return modelMapper.map(enseignantDTO,EnseignantDTO.class);
    }

    @Override
    public EnseignantDTO findById(Long id) {
        Enseignant enseignant = enseignantRepository.findById(id).orElse(null);
        return modelMapper.map(enseignant, EnseignantDTO.class);
    }

    @Override
    public List<EnseignantDTO> findAll() {
        List<Enseignant> enseignants = enseignantRepository.findAll();
        return enseignants.stream().map(enseignant -> modelMapper.map(enseignant,EnseignantDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        enseignantRepository.deleteById(id);
    }
}
