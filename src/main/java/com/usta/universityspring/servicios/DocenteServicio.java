package com.usta.universityspring.servicios;

import com.usta.universityspring.model.Docente;
import com.usta.universityspring.repositories.DocenteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DocenteServicio {
    @Autowired
    private DocenteRepositorio docenteRepositorio;

    public List<Docente> listarDocentes(){
        return docenteRepositorio.findAll();
    }
    public Docente crearDocente( Docente docente){
        return docenteRepositorio.save(docente);
    }
    public Docente editarDocente( Docente docente){
        return docenteRepositorio.save(docente);
    }
    public Optional<Docente> findByIdDocente(Long id){
        return docenteRepositorio.findById(id);
    }
    public void eliminarDocente(Long id){
        docenteRepositorio.deleteById(id);
    }


}
