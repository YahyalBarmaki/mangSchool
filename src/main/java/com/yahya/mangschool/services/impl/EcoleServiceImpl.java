package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EcoleDTO;
import com.yahya.mangschool.entity.Ecole;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.repositories.EcoleRepository;
import com.yahya.mangschool.services.EcoleService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        Optional<Ecole> ecole = ecoleRepository.findById(id);
        if (id == null) {
            log.error("Ecole ID is null");
            return null;
        }
        return ecole.map(ec -> modelMapper.map(ec, EcoleDTO.class)).orElseThrow(
                ()->
        new EntityNotFoundException(
                "Aucune ecole avec l'ID = " + id + " n' ete trouve dans la BDD",
                ErrorCodes.CLASSE_NOT_FOUND)
        );
    }

    @Override
    public EcoleDTO update(Long id, EcoleDTO ecoleDTO) {
        Ecole  ecole= modelMapper.map(ecoleDTO, Ecole.class);
        ecoleRepository.save(ecole);
        return modelMapper.map(ecole,EcoleDTO.class);
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
