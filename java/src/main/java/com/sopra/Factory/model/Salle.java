package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@DiscriminatorValue("salle")
public class Salle extends RessourceMaterielle{
	
	@Column(name = "nb_personne")
	@JsonView(JsonViews.Common.class)
	private Integer nbPersonne;
	
	@OneToMany(mappedBy="salle")
	//@JsonView(JsonViews.SalleByIdWithCursus.class)
    private Set<Cursus> cursus;
	
	

	
	
	
	public Set<Cursus> getCursus() {
		return cursus;
	}


	public void setCursus(Set<Cursus> cursus) {
		this.cursus = cursus;
	}


	public Salle() {
		super();
	}

	
	public Integer getNbPersonne() {
		return nbPersonne;
	}

	public void setNbPersonne(Integer nbPersonne) {
		this.nbPersonne = nbPersonne;
	}
	
	
	

}
