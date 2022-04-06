package com.usta.universityspring.rest;

import com.usta.universityspring.model.Asignaturas;
import com.usta.universityspring.model.Docente;
import com.usta.universityspring.servicios.DocenteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/docente")
public class DocenteRes {
    @Autowired
    private DocenteServicio docenteServicio;

    @GetMapping("/listar")
    private ResponseEntity<List<Docente>> listrarDocente(){
        return ResponseEntity.ok(docenteServicio.listarDocentes());
    }
    @GetMapping(value = "/listar/{id}")
    private ResponseEntity<Optional<Docente>> listrarDocenteById(@PathVariable("id")Long id){
        return ResponseEntity.ok(docenteServicio.findByIdDocente(id));
    }
    @PostMapping("/crearDocente")
    private ResponseEntity<Docente> crearDocente(@RequestBody Docente docente){
        Docente temporal = docenteServicio.crearDocente(docente);
        try{
            return ResponseEntity.created(new URI("/api/docente"+temporal.getCodDocentes())).body(docente);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }
    @PutMapping("/editarDocente")
    private ResponseEntity<Docente>  editarSDocente(@RequestBody Docente docente){
        Docente temporal = docenteServicio.crearDocente(docente);
        try{
            return ResponseEntity.created(new URI("/api/docente"+temporal.getCodDocentes())).body(docente);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/docente/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable("id") Long id){
        docenteServicio.eliminarDocente(id);
        return ResponseEntity.ok().build();
    }
}
