package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.entity.Ecole;
import com.yahya.mangschool.repositories.EcoleRepository;
import com.yahya.mangschool.services.EcoleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EcoleServiceImpl implements EcoleService {

    final private EcoleRepository ecoleRepository;
    final private ModelMapper modelMapper;

    public EcoleServiceImpl( EcoleRepository ecoleRepository, ModelMapper modelMapper) {
        this.ecoleRepository = ecoleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public EcoleDTO save(EcoleDTO ecoleDTO) {
        Ecole ecole = modelMapper.map(ecoleDTO, Ecole.class);
        ecole = ecoleRepository.save(ecole);
        return modelMapper.map(ecole,EcoleDTO.class);
    }

    @Override
    public EcoleDTO findById(Long id) {
        Ecole ecole = ecoleRepository.findById(id).orElse(null);
        return modelMapper.map(ecole, EcoleDTO.class);
    }

    @Override
    public EcoleDTO update(Long id, EcoleDTO ecoleDTO) {
        Optional<Ecole> ecole = ecoleRepository.findById(id);
        if (!ecole.isEmpty()){
        return null;
        }
        modelMapper.map(ecoleDTO,ecole.get());
        ecoleRepository.save(ecole.get());
        return modelMapper.map(ecole.get(),EcoleDTO.class);
    }

    @Override
    public List<EcoleDTO> findAll() {
        List<Ecole> ecoles = ecoleRepository.findAll();
        return ecoles.stream().map(ecole ->modelMapper.map(ecole,EcoleDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        ecoleRepository.deleteById(id);
    }
}
