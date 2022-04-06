package com.usta.universityspring.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "asignaturas")
public class Asignaturas implements Serializable {
    private static final long serialVersion=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_asignatura")
    private Long codAsignatura;

    @Column(name = "semestre_asignatura")
    private Integer semestreAsignatura;

    @Column(name = "nombres_asignatura")
    private String nombreAsignatura;

    @Column(name = "codigo_asignatura")
    private Integer codigoAsignatura;

    @Column(name = "tipo_asignatura")
    private String tipoAsigantura;

    @JoinColumn(name = "cod_docente", referencedColumnName = "cod_docente")
    @ManyToOne(fetch = FetchType.EAGER)
    private Docente idDocente;

    public Asignaturas() {

    }

    public Asignaturas(Long codAsignatura, Integer semestreAsignatura, String nombreAsignatura, Integer codigoAsignatura, String tipoAsigantura, Docente idDocente) {
        this.codAsignatura = codAsignatura;
        this.semestreAsignatura = semestreAsignatura;
        this.nombreAsignatura = nombreAsignatura;
        this.codigoAsignatura = codigoAsignatura;
        this.tipoAsigantura = tipoAsigantura;
        this.idDocente = idDocente;
    }

    public Long getCodAsignatura() {
        return codAsignatura;
    }

    public void setCodAsignatura(Long codAsignatura) {
        this.codAsignatura = codAsignatura;
    }

    public Integer getSemestreAsignatura() {
        return semestreAsignatura;
    }

    public void setSemestreAsignatura(Integer semestreAsignatura) {
        this.semestreAsignatura = semestreAsignatura;
    }

    public String getNombreAsignatura() {
        return nombreAsignatura;
    }

    public void setNombreAsignatura(String nombreAsignatura) {
        this.nombreAsignatura = nombreAsignatura;
    }

    public Integer getCodigoAsignatura() {
        return codigoAsignatura;
    }

    public void setCodigoAsignatura(Integer codigoAsignatura) {
        this.codigoAsignatura = codigoAsignatura;
    }

    public String getTipoAsigantura() {
        return tipoAsigantura;
    }

    public void setTipoAsigantura(String tipoAsigantura) {
        this.tipoAsigantura = tipoAsigantura;
    }

    public Docente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Docente idDocente) {
        this.idDocente = idDocente;
    }
}
