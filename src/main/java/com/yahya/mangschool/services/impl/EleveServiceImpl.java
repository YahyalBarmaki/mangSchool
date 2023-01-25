package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.entity.Eleve;
import com.yahya.mangschool.repositories.EleveRepository;
import com.yahya.mangschool.services.EleveService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EleveServiceImpl implements EleveService {
    final private EleveRepository eleveRepository;
    final private ModelMapper modelMapper;

    public EleveServiceImpl(EleveRepository eleveRepository, ModelMapper modelMapper) {
        this.eleveRepository = eleveRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<EleveDTO> findAll() {
        List<Eleve> eleves = eleveRepository.findAll();
        return eleves.stream().map(eleve -> modelMapper.map(eleve, EleveDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EleveDTO findById(Long id) {
        Eleve eleve = eleveRepository.findById(id).orElse(null);
        return modelMapper.map(eleve, EleveDTO.class);
    }

    @Override
    public EleveDTO update(Long id, EleveDTO eleveDTO) {
        Optional<Eleve> eleve = eleveRepository.findById(id);
        if(!eleve.isEmpty()){
            return null;
        }
        modelMapper.map(eleveDTO,eleve.get());
        eleveRepository.save(eleve.get());
        return modelMapper.map(eleve.get(),EleveDTO.class);
    }

    @Override
    public EleveDTO save(EleveDTO eleveDTO) {
        Eleve eleve = modelMapper.map(eleveDTO,Eleve.class);
        eleve = eleveRepository.save(eleve);
        return modelMapper.map(eleve, EleveDTO.class);
    }

    @Override
    public void delete(Long id) {
            eleveRepository.deleteById(id);
    }
}
