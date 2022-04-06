package com.usta.universityspring.servicios;

import com.usta.universityspring.model.Asignaturas;
import com.usta.universityspring.repositories.AsignaturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AsignaturaServicio {

    @Autowired
    private AsignaturaRepositorio asignaturaRepositorio;


    public List<Asignaturas> listarAsignaturas(){
        return asignaturaRepositorio.findAll();
    }
    public Asignaturas crearAsignatura(Asignaturas asignaturas){
        return asignaturaRepositorio.save(asignaturas);
    }
    public Asignaturas editarrAsignatura(Asignaturas asignaturas){
        return asignaturaRepositorio.save(asignaturas);
    }
    public Optional<Asignaturas> findByIdAsignatura(Long id){
        return asignaturaRepositorio.findById(id);
    }
    public void eliminarAsignatura(Long id){
        asignaturaRepositorio.deleteById(id);
    }
}
