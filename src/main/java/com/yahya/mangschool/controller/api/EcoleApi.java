package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EcoleDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.yahya.mangschool.utils.Constants.APP_ROOT;
public interface EcoleApi {

    @PostMapping(value = APP_ROOT + "/ecoles/add")
    EcoleDTO save(@RequestBody @Valid EcoleDTO ecole);
    @GetMapping(APP_ROOT + "/ecoles/{idEcole}")
    EcoleDTO findById(@PathVariable("idEcole")Long id);
    @PutMapping(APP_ROOT + "/ecoles/update/{idEcole}")
    EcoleDTO update(@PathVariable("idEcole")Long id, @RequestBody @Valid EcoleDTO ecoleDTO);
    @GetMapping(APP_ROOT + "/ecoles/all")
    List<EcoleDTO> findAll();
    @DeleteMapping(APP_ROOT + "/ecoles/delete/{idEcole}")
    void deleteById(@PathVariable("idEcole")Long id);
}
