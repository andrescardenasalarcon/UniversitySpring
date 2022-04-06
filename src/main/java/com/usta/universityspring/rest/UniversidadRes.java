package com.usta.universityspring.rest;


import com.usta.universityspring.model.Universidad;
import com.usta.universityspring.servicios.UniversidadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/universidad")
public class UniversidadRes {

    @Autowired
    private UniversidadServicio universidadServicio;

    @GetMapping("/listar")
    private ResponseEntity<List<Universidad>> listarUniversidad() {
        return ResponseEntity.ok(universidadServicio.getAllUniversidad());
    }
    @PostMapping("/crearUniversidad")
    private ResponseEntity<Universidad> guardarUniversidad(@RequestBody Universidad universidad){
        Universidad temporal = universidadServicio.crearUniversidad(universidad);
        try {
            return ResponseEntity.created(new URI("/api/universidad"+temporal.getCodUniversidad())).body(universidad);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @PutMapping("/editarUniversidad")
    private ResponseEntity<Universidad> editarUniversidad(@RequestBody Universidad universidad){
        Universidad temporal = universidadServicio.editarUniversidad(universidad);
        try {
            return ResponseEntity.created(new URI("/api/universidad"+temporal.getCodUniversidad())).body(universidad);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        }
    }

    @DeleteMapping("/universidad/{id}")
    public String delete(@PathVariable Long id){
        Optional<Universidad> universidad = universidadServicio.findByIdUniversidad(id);
        if (universidad.isPresent()){
            universidadServicio.eliminarUniversidad(id);
            return "universidad eliminada con el id "+id;
        }else{
            throw new RuntimeException("universidad no encontrada con ese id "+id);
        }
    }
}
