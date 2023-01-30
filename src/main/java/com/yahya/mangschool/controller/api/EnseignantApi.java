package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EnseignantDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yahya.mangschool.utils.Constants.APP_ROOT_ENSEIGNANT;
@RequestMapping(value = APP_ROOT_ENSEIGNANT)
public interface EnseignantApi {
    @PostMapping("")
    EnseignantDTO save(@RequestBody @Valid EnseignantDTO ecole);
    @GetMapping("/{id}")
    EnseignantDTO findById(@PathVariable("id") Long id);
    @PutMapping("/{id}")
    EnseignantDTO update(@PathVariable("id") Long id,@RequestBody @Valid EnseignantDTO enseignantDTO);
    @GetMapping("")
    List<EnseignantDTO> findAll();
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id") Long id);
}
