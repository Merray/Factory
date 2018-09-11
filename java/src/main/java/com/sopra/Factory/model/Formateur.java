package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends RessourceHumaine {
	
	@OneToMany(mappedBy="key.formateur")
	private Set<MatiereFormateur> matieres;

	public Formateur() {
		super();
	}

	public Set<MatiereFormateur> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<MatiereFormateur> matieres) {
		this.matieres = matieres;
	}

	
}
