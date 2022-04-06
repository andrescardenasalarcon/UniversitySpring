package com.usta.universityspring.rest;

import com.usta.universityspring.model.Asignaturas;
import com.usta.universityspring.model.Universidad;
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
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Asignaturas>> listrarAsignaturasById(@PathVariable("id")Long id){
        return ResponseEntity.ok(asignaturaServicio.findByIdAsignatura(id));
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
    public ResponseEntity<Void> eliminarAsignaturas(@PathVariable("id") Long id){
        asignaturaServicio.eliminarAsignatura(id);
        return ResponseEntity.ok().build();
    }
}
