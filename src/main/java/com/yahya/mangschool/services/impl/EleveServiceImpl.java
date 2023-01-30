package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.entity.Eleve;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.repositories.EleveRepository;
import com.yahya.mangschool.services.EleveService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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

        Optional<Eleve> eleve = eleveRepository.findById(id);
        if (id == null) {
            log.error("Eleve ID is null");
            return null;
        }
        return eleve.map(el -> modelMapper.map(el,EleveDTO.class)).orElseThrow(
                ()->
                        new EntityNotFoundException(
                                "Aucune ecole avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.ELEVE_NOT_FOUND)
        );
    }

    @Override
    public EleveDTO update(Long id, EleveDTO eleveDTO) {
       Eleve eleve =  modelMapper.map(eleveDTO,Eleve.class);
        eleveRepository.save(eleve);
        return modelMapper.map(eleve,EleveDTO.class);
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
