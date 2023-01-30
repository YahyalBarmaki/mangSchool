package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.MatiereDTO;
import com.yahya.mangschool.entity.Matiere;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.repositories.MatiereRepository;
import com.yahya.mangschool.services.MatiereService;
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
        return matiere.map(mat -> modelMapper.map(mat, MatiereDTO.class)).orElseThrow(
                ()->
                        new EntityNotFoundException(
                                "Aucune matiere avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.MATIERE_NOT_FOUND)
        );
    }

    @Override
    public MatiereDTO save(MatiereDTO matiereDTO) {
        Matiere matiere = modelMapper.map(matiereDTO, Matiere.class);
        matiere = matiereRepository.save(matiere);
        return modelMapper.map(matiere, MatiereDTO.class);
    }

    @Override
    public MatiereDTO update(Long id, MatiereDTO matiereDTO) {
        Matiere matiere = modelMapper.map(matiereDTO, Matiere.class);
        matiereRepository.save(matiere);
        return modelMapper.map(matiere, MatiereDTO.class);
    }

    @Override
    public void delete(Long id) {
        matiereRepository.deleteById(id);
    }
}
