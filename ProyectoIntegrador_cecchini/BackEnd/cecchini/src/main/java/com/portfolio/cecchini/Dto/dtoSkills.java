package com.portfolio.cecchini.Dto;

import javax.validation.constraints.NotBlank;


public class dtoSkills {
    @NotBlank
    private String nombreSk;
    @NotBlank
    private String porcentaje;
    @NotBlank
    private String imgSkills;
    
    
    //constructor

    public dtoSkills() {
    }

    public dtoSkills(String nombreSk, String porcentaje, String imgSkills) {
        this.nombreSk = nombreSk;
        this.porcentaje = porcentaje;
        this.imgSkills = imgSkills;
    }
    
    
    //getter y setter

    public String getNombreSk() {
        return nombreSk;
    }

    public void setNombreSk(String nombreSk) {
        this.nombreSk = nombreSk;
    }

    public String getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(String porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getImgSkills() {
        return imgSkills;
    }

    public void setImgSkills(String imgSkills) {
        this.imgSkills = imgSkills;
    }
    
    
}
