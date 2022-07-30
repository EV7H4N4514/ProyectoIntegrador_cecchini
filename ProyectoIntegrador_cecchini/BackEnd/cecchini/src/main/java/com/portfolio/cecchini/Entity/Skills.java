package com.portfolio.cecchini.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skills {
    
        @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombreSk;
	private String porcentaje;
	private String imgSkills;

	//Constructores

	public Skills() {
	}

	public Skills(String nombreSk, String porcentaje, String imgSkills) {
		this.nombreSk = nombreSk;
		this.porcentaje = porcentaje;
		this.imgSkills = imgSkills;
	}

	//Getters and Setters x Lombok

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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


