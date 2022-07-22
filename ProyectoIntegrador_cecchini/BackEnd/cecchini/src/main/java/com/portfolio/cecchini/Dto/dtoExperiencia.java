package com.portfolio.cecchini.Dto;

import javax.validation.constraints.NotBlank;


public class dtoExperiencia {
   
    @NotBlank
    private String nombreE;
    @NotBlank
    private String descriptionE;
    
    
    //constructor

    public dtoExperiencia() {
    }

    public dtoExperiencia(String nombreE, String descriptionE) {
        this.nombreE = nombreE;
        this.descriptionE = descriptionE;
    }
    
    
    //getters y setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescriptionE() {
        return descriptionE;
    }

    public void setDescriptionE(String descriptionE) {
        this.descriptionE = descriptionE;
    }
    
}
