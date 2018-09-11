package com.sopra.Factory.model;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MatiereFormateurPK {

	@ManyToOne
	@JoinColumn(name="id_matiere")
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="id_ressource_humaine")
	private Formateur formateur;

	public MatiereFormateurPK() {
		super();
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}
	
	
	
}
