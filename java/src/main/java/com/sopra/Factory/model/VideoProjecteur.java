package com.sopra.Factory.model;

import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("video_projecteur")
public class VideoProjecteur extends RessourceMaterielle {
	
	@OneToMany(mappedBy="video_projecteur")
	//@JsonView(JsonViews.VideoProjecteurByIdWithCursus.class)
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
