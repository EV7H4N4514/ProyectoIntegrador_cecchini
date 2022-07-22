package com.portfolio.cecchini.Entity;

import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;

@Entity
public class Experiencia
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreE;
    private String descripcionE;
    
    public Experiencia() {
    }
    
    public Experiencia(final String nombreE, final String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getNombreE() {
        return this.nombreE;
    }
    
    public void setNombreE(final String nombreE) {
        this.nombreE = nombreE;
    }
    
    public String getDescripcionE() {
        return this.descripcionE;
    }
    
    public void setDescripcionE(final String descripcionE) {
        this.descripcionE = descripcionE;
    }
}
