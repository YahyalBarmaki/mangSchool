package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.entity.EmploiDuTemps;
import com.yahya.mangschool.repositories.EmploiDuTempsRepository;
import com.yahya.mangschool.services.EmploiDuTempsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmploiDuTempsServiceImp implements EmploiDuTempsService {
    final private  EmploiDuTempsRepository emploiDuTempsRepository;
    final private ModelMapper modelMapper;

    public EmploiDuTempsServiceImp(EmploiDuTempsRepository emploiDuTempsRepository, ModelMapper modelMapper) {
        this.emploiDuTempsRepository = emploiDuTempsRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EmploiDuTempsDTO> findAll() {
        List<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findAll();
        return emploiDuTemps.stream()
                .map(emploi -> modelMapper.map(emploi, EmploiDuTempsDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmploiDuTempsDTO findById(Long id) {
        Optional<EmploiDuTemps> emploiDuTemps = emploiDuTempsRepository.findById(id);
        return emploiDuTemps.map(emploi -> modelMapper.map(emploi, EmploiDuTempsDTO.class)).orElse(null);
    }

    @Override
    public EmploiDuTempsDTO save(EmploiDuTempsDTO emploiDuTempsDTO) {
        EmploiDuTemps emploiDuTemps = modelMapper.map(emploiDuTempsDTO, EmploiDuTemps.class);
        emploiDuTemps = emploiDuTempsRepository.save(emploiDuTemps);
        return modelMapper.map(emploiDuTemps, EmploiDuTempsDTO.class);
    }

    @Override
    public void delete(Long id) {
        emploiDuTempsRepository.deleteById(id);
    }
}
