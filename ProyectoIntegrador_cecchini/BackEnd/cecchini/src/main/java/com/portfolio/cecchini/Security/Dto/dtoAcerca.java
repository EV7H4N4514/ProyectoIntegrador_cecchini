package com.portfolio.cecchini.Security.Dto;

import javax.validation.constraints.NotBlank;


public class dtoAcerca {
    @NotBlank
    private String nombreA;
    @NotBlank 
    private String descripcionA;
    
    public dtoAcerca(){}
    
    public dtoAcerca(String nombreA, String descripcionA){
        this.nombreA = nombreA;
        this.descripcionA= descripcionA;    
    }
    
    public String getNombreA(){
    return nombreA;
    }
    
    public void setNombreA(String nombreA){
        this.nombreA = nombreA;
    }
    
    public String getDescripcionA(){
        return descripcionA;
    }
    
    public void setDescripcionA(String descripcionA){
        this.descripcionA = descripcionA;
    }
}
