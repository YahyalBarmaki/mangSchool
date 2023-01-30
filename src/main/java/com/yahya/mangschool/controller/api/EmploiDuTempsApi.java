package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EmploiDuTempsDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.yahya.mangschool.utils.Constants.APP_ROOT_EMPLOISDUTEMPS;
@RequestMapping(value = APP_ROOT_EMPLOISDUTEMPS)
public interface EmploiDuTempsApi {

    @GetMapping("")
    List<EmploiDuTempsDTO> findAll();
    @GetMapping("/{id}")
    EmploiDuTempsDTO findById(@PathVariable("id") Long id);
    @PutMapping("/{id}")
    EmploiDuTempsDTO update(@PathVariable("id") Long id,@RequestBody @Valid  EmploiDuTempsDTO emploiDuTempsDTO);
    @PostMapping("")
    EmploiDuTempsDTO save(@RequestBody @Valid EmploiDuTempsDTO  emploiDuTempsDTO);
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void delete(@PathVariable("id") Long id);
}
