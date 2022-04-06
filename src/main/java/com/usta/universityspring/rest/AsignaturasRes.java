package com.usta.universityspring.rest;

import com.usta.universityspring.model.Asignaturas;
import com.usta.universityspring.servicios.AsignaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.security.PrivilegedAction;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/asignaturas")
public class AsignaturasRes {
    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @GetMapping("/listar")
    private ResponseEntity<List<Asignaturas>> listrarAsignaturas(){
        return ResponseEntity.ok(asignaturaServicio.listarAsignaturas());
    }
    @PostMapping("/crearAsignaturas")
    private ResponseEntity<Asignaturas> crearAsignaturas(@RequestBody Asignaturas asignaturas){
        Asignaturas temporal = asignaturaServicio.crearAsignatura(asignaturas);
        try{
            return ResponseEntity.created(new URI("/api/asignaturas"+temporal.getCodAsignatura())).body(asignaturas);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarAsignaturas")
    private ResponseEntity<Asignaturas>  editarSAsignaturas(@RequestBody Asignaturas asignaturas){
        Asignaturas temporal = asignaturaServicio.crearAsignatura(asignaturas);
        try{
            return ResponseEntity.created(new URI("/api/Asignaturas"+temporal.getCodAsignatura())).body(asignaturas);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/Asignaturas/{id}")
    public String eliminarAsignaturas(@PathVariable Long id){
        Optional<Asignaturas> asignaturas = asignaturaServicio.findByIdAsignatura(id);
        if (asignaturas.isPresent()){
            asignaturaServicio.eliminarAsignatura(id);
            return "Asignaturas eliminada con el id "+id;
        }else{
            throw new RuntimeException("Asignaturas no encontrada con ese id "+id);
        }
    }
}
