package com.sopra.Factory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@Table(name="lesson")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "seqLesson", sequenceName = "seq_lesson", initialValue = 1, allocationSize = 1)
public class Lesson {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLesson")
	@Column(name = "id_lesson")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_debut")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateDebut;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_fin")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@JsonView(JsonViews.Common.class)
	private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="id_ressource_humaine")
	@JsonView(JsonViews.Common.class)
	private Formateur formateur;
	
	@ManyToOne
	@JoinColumn(name="id_matiere")
	@JsonView(JsonViews.Common.class)
	private Matiere matiere;
	
	@ManyToOne
	@JoinColumn(name="id_cursus")
	@JsonView(JsonViews.Common.class)
	private Cursus cursus;

	@Version
	private Integer version;
	
	public Lesson() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

	public Cursus getCursus() {
		return cursus;
	}

	public void setCursus(Cursus cursus) {
		this.cursus = cursus;
	}
	
	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
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
		Lesson other = (Lesson) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
