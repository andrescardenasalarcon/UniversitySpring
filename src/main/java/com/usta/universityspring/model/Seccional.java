package com.usta.universityspring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "seccionales")
public class Seccional implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_seccional")
    private Long idSeccional;

    @Column(name = "direccion_seccional")
    private String direccionSeccional;

    @Column(name = "nombre_seccional")
    private String nombreSeccional;

    @JoinColumn(name = "cod_universidad", referencedColumnName = "cod_universidad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Universidad idUniversidad;

    public Seccional(Long idSeccional, String direccionSeccional, String nombreSeccional, Universidad idUniversidad) {
        this.idSeccional = idSeccional;
        this.direccionSeccional = direccionSeccional;
        this.nombreSeccional = nombreSeccional;
        this.idUniversidad = idUniversidad;
    }

    public Seccional() {

    }

    public Long getIdSeccional() {
        return idSeccional;
    }

    public void setIdSeccional(Long idSeccional) {
        this.idSeccional = idSeccional;
    }

    public String getDireccionSeccional() {
        return direccionSeccional;
    }

    public void setDireccionSeccional(String direccionSeccional) {
        this.direccionSeccional = direccionSeccional;
    }

    public String getNombreSeccional() {
        return nombreSeccional;
    }

    public void setNombreSeccional(String nombreSeccional) {
        this.nombreSeccional = nombreSeccional;
    }

    public Universidad getIdUniversidad() {
        return idUniversidad;
    }

    public void setIdUniversidad(Universidad idUniversidad) {
        this.idUniversidad = idUniversidad;
    }
}
