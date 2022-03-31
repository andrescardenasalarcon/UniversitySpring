package com.usta.universityspring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "facultad")
public class Facultad implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_facultad")
    private Long codFacultad;

    @Column(name="nombre_facultad")
    private String nombreFacultad;

    @JoinColumn(name = "cod_seccional",referencedColumnName = "cod_seccional")
    @ManyToOne(fetch = FetchType.EAGER)
    private Seccional idSeccional;

    public Facultad(Long codFacultad, String nombreFacultad, Seccional idSeccional) {
        this.codFacultad = codFacultad;
        this.nombreFacultad = nombreFacultad;
        this.idSeccional = idSeccional;
    }

    public Facultad() {

    }

    public Long getCodFacultad() {
        return codFacultad;
    }

    public void setCodFacultad(Long codFacultad) {
        this.codFacultad = codFacultad;
    }

    public String getNombreFacultad() {
        return nombreFacultad;
    }

    public void setNombreFacultad(String nombreFacultad) {
        this.nombreFacultad = nombreFacultad;
    }

    public Seccional getIdSeccional() {
        return idSeccional;
    }

    public void setIdSeccional(Seccional idSeccional) {
        this.idSeccional = idSeccional;
    }
}
