package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Embeddable
public class Coordonnee {
	
	@JsonView(JsonViews.Common.class)
	@Column(name = "tel_fixe")
	private String telFixe;
	
	@Column(name = "tel_portable")
	@JsonView(JsonViews.Common.class)
	private String telPortable;
	
	@Column(name = "email")
	@JsonView(JsonViews.Common.class)
	private String mail;

	public Coordonnee() {
		super();
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelPortable() {
		return telPortable;
	}

	public void setTelPortable(String telPortable) {
		this.telPortable = telPortable;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
}
