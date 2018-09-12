package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
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
@Table(name = "ressource_materielle")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@SequenceGenerator(name = "seqRessourceMaterielle", sequenceName = "seq_ressource_materielle", initialValue = 1, allocationSize = 1)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Ordinateur.class, name = "ordinateur"), @Type(value = Salle.class, name = "salle"),
		@Type(value = VideoProjecteur.class, name = "video_projecteur") })
public abstract class RessourceMaterielle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRessourceMaterielle")
	@Column(name = "id_ressource_materielle")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@Version
	private int version;
	
	@Column(name = "code")
	@JsonView(JsonViews.Common.class)
	private String code;
	
	@Column(name = "cout_utilisation")
	@JsonView(JsonViews.Common.class)
	private Integer coutUtilisation;

	public RessourceMaterielle() {
		super();
	}
	
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCoutUtilisation() {
		return coutUtilisation;
	}

	public void setCoutUtilisation(Integer coutUtilisation) {
		this.coutUtilisation = coutUtilisation;
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
		RessourceMaterielle other = (RessourceMaterielle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
