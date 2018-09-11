package com.sopra.Factory.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("ordinateur")
public class Ordinateur extends RessourceMaterielle {
	
	@JsonView(JsonView.class)
	@Column(name = "processeur")
	private String processeur;
	@Column(name = "ram")
	private Integer ram;
	@Column(name = "disque_dur")
	private Integer disqueDur;
	@Column(name = "annee_achat")
	private Date anneeAchat;
	
	@OneToMany(mappedBy="ordinateur")
	//@JsonView(JsonViews.OrdinateurByIdWithStagiaires.class)
    private Set<Stagiaire> stagiaires;
	
	public String getProcesseur() {
		return processeur;
	}
	public void setProcesseur(String processeur) {
		this.processeur = processeur;
	}
	public Integer getRam() {
		return ram;
	}
	public void setRam(Integer ram) {
		this.ram = ram;
	}
	public Integer getDisqueDur() {
		return disqueDur;
	}
	public void setDisqueDur(Integer disqueDur) {
		this.disqueDur = disqueDur;
	}
	public Date getAnneeAchat() {
		return anneeAchat;
	}
	public void setAnneeAchat(Date anneeAchat) {
		this.anneeAchat = anneeAchat;
	}
	
	
	
	public Set<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(Set<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	public Ordinateur() {
		super();
	}
	
	
	

}
