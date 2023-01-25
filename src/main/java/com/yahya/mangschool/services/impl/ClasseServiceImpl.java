package com.yahya.mangschool.services.impl;

import com.yahya.mangschool.dto.ClasseDTO;
import com.yahya.mangschool.entity.Classe;
import com.yahya.mangschool.repositories.ClasseRepository;
import com.yahya.mangschool.services.ClasseService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
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
        return classe.map(c -> modelMapper.map(c, ClasseDTO.class)).orElse(null);
    }

    @Override
    public ClasseDTO save(ClasseDTO classeDTO) {
        Classe classe = modelMapper.map(classeDTO, Classe.class);
        classe = classeRepository.save(classe);
        return modelMapper.map(classe, ClasseDTO.class);
    }

    @Override
    public ClasseDTO update(Long id, ClasseDTO classeDTO) {
        Optional<Classe> classe = classeRepository.findById(id);
        if(!classe.isEmpty()){
        return null;
        }
        modelMapper.map(classeDTO,classe.get());
        classeRepository.save(classe.get());
        return modelMapper.map(classe.get(), ClasseDTO.class);
    }

    @Override
    public void delete(Long id) {
        classeRepository.deleteById(id);
    }
}
