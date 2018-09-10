package com.sopra.Factory.model;

public enum Profil {
	Débutant(0), Intermédiaire(1), Avancé(2), Expert(3);

	private Integer niveau;

	private Profil() {
	}

	private Profil(Integer niveau) {
		this.niveau = niveau;
	}

	public Integer getNiveau() {
		return niveau;
	}

	public void setNiveau(Integer niveau) {
		this.niveau = niveau;
	}
	
	
	
}
