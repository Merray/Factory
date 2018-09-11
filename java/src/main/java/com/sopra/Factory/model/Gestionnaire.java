package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@DiscriminatorValue("Gestionnaire")
public class Gestionnaire extends RessourceHumaine {
	
	
	@OneToMany(mappedBy = "gestionnaire", fetch = FetchType.LAZY)
	@JsonView(JsonViews.Common.class)
	private Set<Cursus> cursusGeres;

	public Gestionnaire() {
		super();
	}

	public Set<Cursus> getCursusGeres() {
		return cursusGeres;
	}

	public void setCursusGeres(Set<Cursus> cursusGeres) {
		this.cursusGeres = cursusGeres;
	}
	
}
