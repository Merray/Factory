package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@DiscriminatorValue("Formateur")
public class Formateur extends RessourceHumaine {
	
	@OneToMany(mappedBy="key.formateur")
	@JsonView(JsonViews.FormateurCustomWithAll.class)
	private Set<MatiereFormateur> matieres;
	
	@OneToMany(mappedBy="formateur")
	@JsonView(JsonViews.FormateurCustomWithAll.class)
	private Set<Lesson> lessons;

	public Formateur() {
		super();
	}

	public Set<MatiereFormateur> getMatieres() {
		return matieres;
	}

	public void setMatieres(Set<MatiereFormateur> matieres) {
		this.matieres = matieres;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	
	
}
