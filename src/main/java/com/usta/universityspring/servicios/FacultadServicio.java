package com.usta.universityspring.servicios;

import com.usta.universityspring.model.Facultad;
import com.usta.universityspring.repositories.FacultadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultadServicio {

    @Autowired
    private FacultadRepositorio facultadRepositorio;

    public List<Facultad> listarFacultades(){
        return facultadRepositorio.findAll();
    }
    public Facultad crearFacultad(Facultad facultad){
        return facultadRepositorio.save(facultad);
    }
    public Optional<Facultad> findByIdFacultad(Long id){
        return facultadRepositorio.findById(id);
    }
    public void eliminarFacultad(Long id){
        facultadRepositorio.deleteById(id);
    }
    public Facultad editarFacultad(Facultad facultad){
        return facultadRepositorio.save(facultad);
    }
}
