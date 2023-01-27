package com.yahya.mangschool.controller.api;

import com.yahya.mangschool.dto.EleveDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import static com.yahya.mangschool.utils.Constants.APP_ROOT;
public interface EleveApi {

    @GetMapping(APP_ROOT + "/eleves/all")
    List<EleveDTO> findAll();
    @GetMapping(APP_ROOT + "/eleves/{idEleve}")
    EleveDTO findById(@PathVariable("idEleve") Long id);
    @PutMapping(APP_ROOT + "/eleves/update/{idEleve}")
    EleveDTO update(@PathVariable("idEleve")Long id, @RequestBody EleveDTO eleveDTO);
    @PostMapping(value = APP_ROOT + "/eleves/add")
    EleveDTO save(@RequestBody EleveDTO eleveDTO);
    @DeleteMapping(APP_ROOT + "/eleves/delete/{idEleve}")
    void delete(@PathVariable("idEleve") Long id);
}
