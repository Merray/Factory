package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="matiere")
@SequenceGenerator(name = "seqMatiere", sequenceName = "seq_matiere", initialValue = 1, allocationSize = 1)
public class Matiere {
	
	@Id
	@Column(name= "id_matiere")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMatiere")
	private Integer id;
	
	@Version
	private Integer version;

}
