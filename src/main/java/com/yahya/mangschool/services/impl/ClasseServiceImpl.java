package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.entity.Classe;
import com.yahya.mangschool.exeption.EntityNotFoundException;
import com.yahya.mangschool.exeption.ErrorCodes;
import com.yahya.mangschool.repositories.ClasseRepository;
import com.yahya.mangschool.services.ClasseService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClasseServiceImpl implements ClasseService {
    final private ClasseRepository classeRepository;
    final private ModelMapper modelMapper;

    public ClasseServiceImpl(ClasseRepository classeRepository, ModelMapper modelMapper) {
        this.classeRepository = classeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ClasseDTO> findAll() {
        List<Classe> classes = classeRepository.findAll();
        return classes.stream().map(
                classe -> modelMapper.map(classe, ClasseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public ClasseDTO findById(Long id) {
        Optional<Classe> classe = classeRepository.findById(id);
        if (id == null) {
            log.error("Classe ID is null");
            return null;
        }
        return classe.map(cl -> modelMapper.map(cl, ClasseDTO.class)).orElseThrow(
                () ->
                        new EntityNotFoundException(
                                "Aucune avec l'ID = " + id + " n' ete trouve dans la BDD",
                                ErrorCodes.CLASSE_NOT_FOUND)
        );
    }

    @Override
    public ClasseDTO save(ClasseDTO classeDTO) {

        Classe classe = modelMapper.map(classeDTO, Classe.class);
        classe = classeRepository.save(classe);
        return modelMapper.map(classe, ClasseDTO.class);
    }

    @Override
    public ClasseDTO update(Long id, ClasseDTO classeDTO) {

        Classe classe = modelMapper.map(classeDTO, Classe.class);
        classeRepository.save(classe);
        return modelMapper.map(classe, ClasseDTO.class);
    }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Classe ID is null");
            return ;
        }
        classeRepository.deleteById(id);
    }
}
