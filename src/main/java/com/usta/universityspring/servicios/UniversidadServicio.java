package com.usta.universityspring.servicios;

import com.usta.universityspring.model.Universidad;
import com.usta.universityspring.repositories.UniversidadRepositorios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UniversidadServicio {

    @Autowired
    private UniversidadRepositorios universidadRepositorios;

    public List<Universidad> getAllUniversidad(){
        return universidadRepositorios.findAll();
    }
    public Universidad crearUniversidad (Universidad universidad){return universidadRepositorios.save(universidad);}
    public Universidad editarUniversidad (Universidad universidad){
        return universidadRepositorios.save(universidad);
    }
    public Optional<Universidad> findByIdUniversidad(Long id){
        return universidadRepositorios.findById(id);
    }
    public void eliminarUniversidad(Long id){
        universidadRepositorios.deleteById(id);
    }
}
