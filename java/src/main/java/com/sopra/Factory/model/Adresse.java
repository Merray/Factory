package com.sopra.Factory.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonView;

@Embeddable
public class Adresse {

	@JsonView(JsonViews.Common.class)
	@Column(name = "numero")
	private Integer numero;

	@Column(name = "rue")
	@JsonView(JsonViews.Common.class)
	private String rue;

	@Column(name = "code_postal")
	@JsonView(JsonViews.Common.class)
	private Integer cp;

	@Column(name = "ville")
	@JsonView(JsonViews.Common.class)
	private String ville;

	public Adresse() {
		super();
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

}
