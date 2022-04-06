package com.usta.universityspring.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "docente")
public class Docente implements Serializable {
    private static final long serialVersion=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_docente")
    private Long codDocentes;

    @Column(name = "documento_docente")
    private String docuemntoDocente;

    @Column(name = "apellido_docente")
    private String apellidoDocente;

    @Column(name = "nombre_docente")
    private String nombreDocente;

    @Column(name = "tipo_docente")
    private Integer tipoDocente;

    @JoinColumn(name = "cod_facultad", referencedColumnName = "cod_facultad")
    @ManyToOne(fetch = FetchType.EAGER)
    private Facultad idFacultad;

    public Docente() {

    }

    public Docente(Long codDocentes, String docuemntoDocente, String apellidoDocente, String nombreDocente, Integer tipoDocente, Facultad idFacultad) {
        this.codDocentes = codDocentes;
        this.docuemntoDocente = docuemntoDocente;
        this.apellidoDocente = apellidoDocente;
        this.nombreDocente = nombreDocente;
        this.tipoDocente = tipoDocente;
        this.idFacultad = idFacultad;
    }

    public Long getCodDocentes() {
        return codDocentes;
    }

    public void setCodDocentes(Long codDocentes) {
        this.codDocentes = codDocentes;
    }

    public String getDocuemntoDocente() {
        return docuemntoDocente;
    }

    public void setDocuemntoDocente(String docuemntoDocente) {
        this.docuemntoDocente = docuemntoDocente;
    }

    public String getApellidoDocente() {
        return apellidoDocente;
    }

    public void setApellidoDocente(String apellidoDocente) {
        this.apellidoDocente = apellidoDocente;
    }

    public String getNombreDocente() {
        return nombreDocente;
    }

    public void setNombreDocente(String nombreDocente) {
        this.nombreDocente = nombreDocente;
    }

    public Integer getTipoDocente() {
        return tipoDocente;
    }

    public void setTipoDocente(Integer tipoDocente) {
        this.tipoDocente = tipoDocente;
    }

    public Facultad getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Facultad idFacultad) {
        this.idFacultad = idFacultad;
    }
}
