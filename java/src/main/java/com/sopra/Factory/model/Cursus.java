package com.sopra.Factory.model;

import java.util.Date;
import java.util.Optional;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.TPVolAngular.model.view.JsonViews;


@Entity
@Table(name = "cursus")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "seqRessourceMateriel", sequenceName = "seq_ressource_materielle", initialValue = 1, allocationSize = 1)
public class Cursus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCursus")
	@Column(name = "id_cursus")
	private Integer id;
	@Version
	private int version;
	@Column(name = "date_debut")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDebut;
	@Column(name = "date_fin")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name = "id_ressource_materielle")
	//@JsonView(JsonViews.CursusByIdWithVideoProjecteur.class)
	private Optional<VideoProjecteur> videoProjecteur;
	
	@ManyToOne
	@JoinColumn(name = "id_ressource_materielle")
	//@JsonView(JsonViews.CursusByIdWithSalle.class)
	private Salle salle;
	
	@Column(name = "nb_stagiaire")
	private Integer nbStagiaire;
	
	@OneToMany(mappedBy="id_ressource_humaine")
	//@JsonView(JsonViews.CursusByIdWithStagiaires.class)
    private Set<Stagiaire> stagiaires;
	
	@ManyToOne
	@JoinColumn(name = "id_ressource_humaine")
	//@JsonView(JsonViews.CursusByIdWithGestionnaire.class)
	private Gestionnaire gestionnaire;
	
	@OneToMany(mappedBy="id_lecon")
	//@JsonView(JsonViews.CursusByIdWithLessons.class)
    private Set<Lesson> lessons;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Optional<VideoProjecteur> getVideoProjecteur() {
		return videoProjecteur;
	}

	public void setVideoProjecteur(Optional<VideoProjecteur> videoProjecteur) {
		this.videoProjecteur = videoProjecteur;
	}
	
	

	public Integer getNbStagiaire() {
		return nbStagiaire;
	}

	public void setNbStagiaire(Integer nbStagiaire) {
		this.nbStagiaire = nbStagiaire;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}

	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}

	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public Gestionnaire getGestionnaire() {
		return gestionnaire;
	}

	public void setGestionnaire(Gestionnaire gestionnaire) {
		this.gestionnaire = gestionnaire;
	}

	public Set<Lesson> getLessons() {
		return lessons;
	}

	public void setLessons(Set<Lesson> lessons) {
		this.lessons = lessons;
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
		Cursus other = (Cursus) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Cursus() {
		super();
	}
	
	
	

}
