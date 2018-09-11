package com.sopra.Factory.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="matiere_formateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class MatiereFormateur {
	
	@EmbeddedId
	private MatiereFormateurPK key;

	public MatiereFormateur() {
		super();
	}

	public MatiereFormateurPK getKey() {
		return key;
	}

	public void setKey(MatiereFormateurPK key) {
		this.key = key;
	}
	
	

}
