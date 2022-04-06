package com.usta.universityspring.servicios;

import com.usta.universityspring.model.Seccional;
import com.usta.universityspring.repositories.SeccionalRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeccionalServicio {

    @Autowired
    private SeccionalRepositorio seccionalRepositorio;

    public List<Seccional> getAllSeccional(){
        return seccionalRepositorio.findAll();
    }
    public Seccional crearSeccional (Seccional seccional){
        return seccionalRepositorio.save(seccional);
    }
    public Optional<Seccional> findByIdSeccional(Long id){
        return seccionalRepositorio.findById(id);
    }
    public void eliminarSeccional (Long id){
       seccionalRepositorio.deleteById(id);
    }
    public Seccional editarSeccional(Seccional seccional){
        return seccionalRepositorio.save(seccional);
    }
}
