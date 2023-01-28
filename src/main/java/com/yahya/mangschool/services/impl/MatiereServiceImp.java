package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.EnseignantDTO;
import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.entity.Matiere;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.exeption.InvalidEntityException;
import com.yahya.mangschool.repositories.MatiereRepository;
import com.yahya.mangschool.services.MatiereService;
import com.yahya.mangschool.validators.MatiereValidator;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
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
        if (id == null) {
            log.error("Matiere ID is null");
            return null;
        }
        return matiere.map(c -> modelMapper.map(matiere, MatiereDTO.class)).orElseThrow(
                ()->
                        new EntityNotFoundException(
                                "Aucune matiere avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.MATIERE_NOT_FOUND)
        );
    }

    @Override
    public MatiereDTO save(MatiereDTO matiereDTO) {
        List<String> errors = MatiereValidator.validate(matiereDTO);
        if (errors.isEmpty()){
            log.error("Matiere is not valid {}", matiereDTO);
            throw new InvalidEntityException("La matiere n'est pas valide", ErrorCodes.MATIERE_NOT_VALID,errors);
        }
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
