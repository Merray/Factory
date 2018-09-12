package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@Table(name = "matiere")
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 1, allocationSize = 1)
public class Matiere {

	@Id
	@Column(name = "id_matiere")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatiere")
	@JsonView(JsonViews.Common.class)
	private Integer id;

	@Version
	private Integer version;

	@Enumerated(EnumType.STRING)
	@Column(name = "niveau")
	@JsonView(JsonViews.Common.class)
	private Profil niveau;
	
	@Column(name = "titre")
	@JsonView(JsonViews.Common.class)
	private String titre;

	@Column(name = "duree")
	@JsonView(JsonViews.Common.class)
	private Integer duree;

	@Column(name = "objectif")
	@JsonView(JsonViews.Common.class)
	private String objectif;

	@Column(name = "prerequis")
	@JsonView(JsonViews.Common.class)
	private String prerequis;

	@Column(name = "contenu")
	@JsonView(JsonViews.Common.class)
	private String contenu;

	@OneToMany(mappedBy = "matiere", fetch = FetchType.LAZY)
	@JsonView(JsonViews.Common.class)
	private Set<Lesson> lessons;

	@OneToMany(mappedBy = "key.matiere")
	private Set<MatiereFormateur> formateurs;

	public Matiere() {
		super();
	}
	
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Profil getNiveau() {
		return niveau;
	}

	public void setNiveau(Profil niveau) {
		this.niveau = niveau;
	}

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
	}

	public String getObjectif() {
		return objectif;
	}

	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}

	public String getPrerequis() {
		return prerequis;
	}

	public void setPrerequis(String prerequis) {
		this.prerequis = prerequis;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
	}

	public Set<MatiereFormateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(Set<MatiereFormateur> formateurs) {
		this.formateurs = formateurs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matiere other = (Matiere) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
