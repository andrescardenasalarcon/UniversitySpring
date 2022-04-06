package com.usta.universityspring.rest;

import com.usta.universityspring.model.Docente;
import com.usta.universityspring.model.Seccional;
import com.usta.universityspring.servicios.SeccionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/seccional")
public class SeccionalRes {
    @Autowired
    private SeccionalServicio seccionalServicio;

    @GetMapping("/listar")
    private ResponseEntity<List<Seccional>> listrarSeccional(){
        return ResponseEntity.ok(seccionalServicio.getAllSeccional());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Seccional>> listrarSeccionalById(@PathVariable("id")Long id){
        return ResponseEntity.ok(seccionalServicio.findByIdSeccional(id));
    }
    @PostMapping("/crearSeccional")
    private ResponseEntity<Seccional> crearSeccional(@RequestBody Seccional seccional){
        Seccional temporal = seccionalServicio.crearSeccional(seccional);
        try{
            return ResponseEntity.created(new URI("/api/seccional"+temporal.getCodSeccional())).body(seccional);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarSeccional")
    private ResponseEntity<Seccional>  editarSseccional(@RequestBody Seccional seccional){
        Seccional temporal = seccionalServicio.crearSeccional(seccional);
        try{
            return ResponseEntity.created(new URI("/api/seccional"+temporal.getCodSeccional())).body(seccional);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/seccional/{id}")
    public  ResponseEntity<Void> eliminarSeccional(@PathVariable("id") Long id){
        seccionalServicio.eliminarSeccional(id);
        return ResponseEntity.ok().build();
    }
}
