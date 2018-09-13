package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@Table(name = "ressource_humaine")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "seqRessourceHumaine", sequenceName = "seq_ressource_humaine", initialValue = 1, allocationSize = 1)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ 
		@Type(value = Stagiaire.class, name = "Stagiaire"),
		@Type(value = Gestionnaire.class, name = "Gestionnaire"), 
		@Type(value = Technicien.class, name = "Technicien"),
		@Type(value = Formateur.class, name = "Formateur") })
public abstract class RessourceHumaine {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRessourceHumaine")
	@Column(name = "id_ressource_humaine")
	@JsonView(JsonViews.Common.class)
	private Integer id;

	@Column(name = "nom")
	@JsonView(JsonViews.Common.class)
	private String nom;

	@Column(name = "prenom")
	@JsonView(JsonViews.Common.class)
	private String prenom;

	@Embedded
	@JsonView(JsonViews.RessourceHumaineCustomWithAll.class)
	private Coordonnee coordonnee;

	@Embedded
	@JsonView(JsonViews.RessourceHumaineCustomWithAll.class)
	private Adresse adresse;

	@Version
	private int version;

	public RessourceHumaine() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		RessourceHumaine other = (RessourceHumaine) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
