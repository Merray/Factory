package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Gestionnaire")
public class Gestionnaire extends RessourceHumaine {
	
	
	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY)
	private Set<Cursus> cursusGeres;

}
