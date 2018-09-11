package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@DiscriminatorValue("Stagiaire")
public class Stagiaire extends RessourceHumaine {

	@Enumerated(EnumType.STRING)
	@Column(name="profil")
	@JsonView(JsonViews.Common.class)
	private Profil profil;
	
	@ManyToOne
	@JoinColumn(name = "id_ressource_materielle")
	@JsonView(JsonViews.Common.class)
	private Ordinateur ordinateur;
	
	@ManyToOne
	@JoinColumn(name="id_cursus")
	@JsonView(JsonViews.Common.class)
	private Cursus cursus;

	public Stagiaire() {
		super();
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}

	
}
