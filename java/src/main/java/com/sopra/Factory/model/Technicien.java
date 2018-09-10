package com.sopra.Factory.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Technicien")
public class Technicien extends RessourceHumaine {

	public Technicien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
