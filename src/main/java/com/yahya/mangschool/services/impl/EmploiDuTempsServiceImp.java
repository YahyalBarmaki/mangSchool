package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.entity.EmploiDuTemps;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.repositories.EmploiDuTempsRepository;
import com.yahya.mangschool.services.EmploiDuTempsService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
        if (id == null) {
            log.error("EmploiDuTemps ID is null");
            return null;
        }
        return emploiDuTemps.map(emp -> modelMapper.map(emp, EmploiDuTempsDTO.class)).orElseThrow(
                ()->
                        new EntityNotFoundException(
                                "Aucun emploiDuTemps avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.EmploiDuTemps_NOT_FOUND)
        );
    }

    @Override
    public EmploiDuTempsDTO update(Long id, EmploiDuTempsDTO emploiDuTempsDTO) {

        EmploiDuTemps  emploiDuTemps= modelMapper.map(emploiDuTempsDTO,EmploiDuTemps.class);
        emploiDuTempsRepository.save(emploiDuTemps);
        return  modelMapper.map(emploiDuTemps,EmploiDuTempsDTO.class);
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
