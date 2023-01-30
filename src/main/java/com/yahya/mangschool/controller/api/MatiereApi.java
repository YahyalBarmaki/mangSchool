package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.MatiereDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yahya.mangschool.utils.Constants.APP_ROOT_MATIERE;
@RequestMapping(value = APP_ROOT_MATIERE)
public interface MatiereApi {
    @GetMapping("/matieres/all")
    List<MatiereDTO> findAll();
    @GetMapping("/{id}")
    MatiereDTO findById(@PathVariable("id") Long id);
    @PostMapping("")
    MatiereDTO save(@RequestBody @Valid MatiereDTO matiereDTO);
    @PutMapping("/{id}")
    MatiereDTO update(@PathVariable("id") Long id, @RequestBody @Valid MatiereDTO matiereDTO);
    @DeleteMapping( "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}
