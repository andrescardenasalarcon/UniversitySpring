package com.usta.universityspring.rest;


import com.usta.universityspring.model.Facultad;
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
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Universidad>> listarUniversidadById(@PathVariable("id")Long id){
        return ResponseEntity.ok(universidadServicio.findByIdUniversidad(id));
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
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        universidadServicio.eliminarUniversidad(id);
        return ResponseEntity.ok().build();
    }
}
