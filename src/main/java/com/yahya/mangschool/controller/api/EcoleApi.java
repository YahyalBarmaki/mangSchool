package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EcoleDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.yahya.mangschool.utils.Constants.APP_ROOT_ECOLE;


@RequestMapping(value = APP_ROOT_ECOLE )
public interface EcoleApi {

    @PostMapping(value =  "")
    EcoleDTO save(@RequestBody @Valid EcoleDTO ecole);
    @GetMapping( "/{id}")
    EcoleDTO findById(@PathVariable("id")Long id);
    @PutMapping( "/{id}")
    EcoleDTO update(@PathVariable("id")Long id, @RequestBody @Valid EcoleDTO ecoleDTO);
    @GetMapping( "")
    List<EcoleDTO> findAll();
    @DeleteMapping( "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteById(@PathVariable("id")Long id);
}
