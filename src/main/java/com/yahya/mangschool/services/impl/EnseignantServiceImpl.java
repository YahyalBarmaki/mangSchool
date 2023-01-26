package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EleveDTO;
import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.entity.Eleve;
import com.yahya.mangschool.entity.Enseignant;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.exeption.InvalidEntityException;
import com.yahya.mangschool.repositories.EnseignantRepository;
import com.yahya.mangschool.services.EnseignantService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
        if (enseignant == null){
            log.error("Enseignant is not valid {}", enseignantDTO);
            throw new InvalidEntityException("L\"enseignant n'est pas valide", ErrorCodes.Enseignant_NOT_VALID);
        }
        enseignantRepository.save(enseignant);
        return modelMapper.map(enseignantDTO,EnseignantDTO.class);
    }

    @Override
    public EnseignantDTO findById(Long id) {
       Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (id == null) {
            log.error("Enseignant ID is null");
            return null;
        }
        return enseignant.map(c -> modelMapper.map(enseignant, EnseignantDTO.class)).orElseThrow(
                ()->
                        new EntityNotFoundException(
                                "Aucun enseignant avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.Enseignant_NOT_FOUND)
        );
    }

    @Override
    public EnseignantDTO update(Long id, EnseignantDTO enseignantDTO) {
        Optional<Enseignant> enseignant = enseignantRepository.findById(id);
        if (enseignant.isEmpty()) {
            return null;
        }
        modelMapper.map(enseignantDTO, enseignant.get());
        enseignantRepository.save(enseignant.get());
        return modelMapper.map(enseignant.get(), EnseignantDTO.class);
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
