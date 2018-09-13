package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.view.JsonViews;

@Entity
@DiscriminatorValue("video_projecteur")
public class VideoProjecteur extends RessourceMaterielle {
	
	
	@OneToMany(mappedBy="videoProjecteur", fetch = FetchType.LAZY)
	@JsonView(JsonViews.VideoProjecteurCustomWithAll.class)
    private Set<Cursus> cursus;
	
	public VideoProjecteur() {
		super();
	}

	public Set<Cursus> getCursus() {
		return cursus;
	}

	public void setCursus(Set<Cursus> cursus) {
		this.cursus = cursus;
	}
	
	

}
