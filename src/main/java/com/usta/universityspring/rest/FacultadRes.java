package com.usta.universityspring.rest;

import com.usta.universityspring.model.Facultad;
import com.usta.universityspring.model.Seccional;
import com.usta.universityspring.servicios.FacultadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/facultad")
public class FacultadRes {
    @Autowired
    private FacultadServicio facultadServicio;

    @GetMapping("/listar")
    private ResponseEntity<List<Facultad>> listrarFacultades(){
        return ResponseEntity.ok(facultadServicio.listarFacultades());
    }
    @PostMapping("/crearFacultad")
    private ResponseEntity<Facultad> crearFacultad(@RequestBody Facultad facultad){
        Facultad temporal = facultadServicio.crearFacultad(facultad);
        try{
            return ResponseEntity.created(new URI("/api/facultad"+temporal.getCodFacultad())).body(facultad);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/editarFacultad")
    private ResponseEntity<Facultad> editarFacultad(@RequestBody Facultad facultad){
        Facultad temporal = facultadServicio.crearFacultad(facultad);
        try{
            return ResponseEntity.created(new URI("/api/facultad"+temporal.getCodFacultad())).body(facultad);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Facultad>> listarFacultadById(@PathVariable("id")Long id){
        return ResponseEntity.ok(facultadServicio.findByIdFacultad(id));
    }
    @DeleteMapping("/facultad/{id}")
    public String eliminarFacultad(@PathVariable Long id){
        Optional<Facultad> facultad = facultadServicio.findByIdFacultad(id);
        if (facultad.isPresent()){
            facultadServicio.eliminarFacultad(id);
            return "facultad eliminada con el id "+id;
        }else{
            throw new RuntimeException("facultad no encontrada con ese id "+id);
        }
    }

}
