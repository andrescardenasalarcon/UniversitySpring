package com.usta.universityspring.repositories;

import com.usta.universityspring.model.Asignaturas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepositorio extends JpaRepository<Asignaturas,Long> {
}
