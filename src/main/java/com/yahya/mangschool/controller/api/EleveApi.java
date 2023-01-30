package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EleveDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.yahya.mangschool.utils.Constants.APP_ROOT_ELEVE;
@RequestMapping(value = APP_ROOT_ELEVE)
public interface EleveApi {

    @GetMapping("")
    List<EleveDTO> findAll();
    @GetMapping("/{id}")
    EleveDTO findById(@PathVariable("id") Long id);
    @PutMapping( "/{id}")
    EleveDTO update(@PathVariable("id")Long id, @RequestBody @Valid EleveDTO eleveDTO);
    @PostMapping("")
    EleveDTO save(@RequestBody @Valid EleveDTO eleveDTO);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}
