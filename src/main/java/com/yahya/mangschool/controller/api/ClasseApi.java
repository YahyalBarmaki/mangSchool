package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.ClasseDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.yahya.mangschool.utils.Constants.APP_ROOT_CLASSE;
import java.util.List;
@RequestMapping(value = APP_ROOT_CLASSE)
public interface ClasseApi {
    @GetMapping()
    List<ClasseDTO> findAll();
    @GetMapping("/{id}")
    ClasseDTO findById(@PathVariable("id") Long id);
    @PostMapping("")
    ClasseDTO save(@RequestBody @Valid ClasseDTO classeDTO);
    @PutMapping("/{id}")
    ClasseDTO update(@PathVariable("id") Long id, @RequestBody @Valid ClasseDTO classeDTO);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}
