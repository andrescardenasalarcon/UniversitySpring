package com.usta.universityspring.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "universidad")
public class Universidad implements Serializable {
    private static final long serialVersion=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_universidad")
    private Long codUniversidad;

    @Column(name = "nombre_universidad")
    private String nombreUniversidad;

    @Column(name = "nit_universidad")
    private String nitUniversidad;

    public Universidad(Long codUniversidad, String nombreUniversidad, String nitUniversidad) {
        this.codUniversidad = codUniversidad;
        this.nombreUniversidad = nombreUniversidad;
        this.nitUniversidad = nitUniversidad;
    }

    public Universidad() {

    }

    public Long getCodUniversidad() {
        return codUniversidad;
    }

    public void setCodUniversidad(Long codUniversidad) {
        this.codUniversidad = codUniversidad;
    }

    public String getNombreUniversidad() {
        return nombreUniversidad;
    }

    public void setNombreUniversidad(String nombreUniversidad) {
        this.nombreUniversidad = nombreUniversidad;
    }

    public String getNitUniversidad() {
        return nitUniversidad;
    }

    public void setNitUniversidad(String nitUniversidad) {
        this.nitUniversidad = nitUniversidad;
    }
}
