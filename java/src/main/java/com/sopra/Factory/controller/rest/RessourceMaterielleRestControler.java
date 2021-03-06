package com.sopra.Factory.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.Ordinateur;
import com.sopra.Factory.model.RessourceMaterielle;
import com.sopra.Factory.model.Salle;
import com.sopra.Factory.model.VideoProjecteur;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.OrdinateurRepository;
import com.sopra.Factory.repositories.RessourceMaterielleRepository;
import com.sopra.Factory.repositories.SalleRepository;
import com.sopra.Factory.repositories.VideoProjecteurRepository;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/rest/ressourcematerielle")
public class RessourceMaterielleRestControler {

	@Autowired
	RessourceMaterielleRepository ressourceMaterielleRepository;
	
	@Autowired
	OrdinateurRepository ordinateurRepository;
	
	@Autowired
	SalleRepository salleRepository;
	
	@Autowired
	VideoProjecteurRepository videoProjecteurRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "", "/" })
	public ResponseEntity<List<RessourceMaterielle>> findAll() {
		ResponseEntity<List<RessourceMaterielle>> response = null;
		response = new ResponseEntity<>(ressourceMaterielleRepository.findAll(), HttpStatus.OK);
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/ordinateur", "/ordinateur/" })
	public ResponseEntity<List<Ordinateur>> findAllOrdinateur() {
		ResponseEntity<List<Ordinateur>> response = null;
		response = new ResponseEntity<>(ordinateurRepository.findAll(), HttpStatus.OK);
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/salle", "/salle/" })
	public ResponseEntity<List<Salle>> findAllSalle() {
		ResponseEntity<List<Salle>> response = null;
		response = new ResponseEntity<>(salleRepository.findAll(), HttpStatus.OK);
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/videoprojecteur", "/videoprojecteur/" })
	public ResponseEntity<List<VideoProjecteur>> findAllVideoProjecteur() {
		ResponseEntity<List<VideoProjecteur>> response = null;
		response = new ResponseEntity<>(videoProjecteurRepository.findAll(), HttpStatus.OK);
		return response;
	}
	

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<RessourceMaterielle> findById(@PathVariable(name = "id") Integer id) {
		ResponseEntity<RessourceMaterielle> response = null;
		Optional<RessourceMaterielle> opt = ressourceMaterielleRepository.findById(id);
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(path = { "/ordinateur", "/ordinateur/" })
	public ResponseEntity<Void> createOrdinateur(@Valid @RequestBody Ordinateur ordinateur, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(ordinateur);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/ressourcematerielle/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/videoprojecteur", "/videoprojecteur/" })
	public ResponseEntity<Void> createVideoProjecteur(@Valid @RequestBody VideoProjecteur videoProjecteur,
			BindingResult br, UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(videoProjecteur);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/ressourcematerielle/videoprojecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/salle", "/salle/" })
	public ResponseEntity<Void> createSalle(@Valid @RequestBody Salle salle, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(salle);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/ressourcematerielle/salle/{id}").buildAndExpand(salle.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<RessourceMaterielle> update(@Valid @RequestBody RessourceMaterielle ressourceMaterielle, BindingResult br) {
		if (br.hasErrors() || ressourceMaterielle.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceMaterielle> opt = ressourceMaterielleRepository.findById(ressourceMaterielle.getId());
		if (opt.isPresent()) {
			// update possible
			RessourceMaterielle ressourceMaterielleEnBase = opt.get();
			
			ressourceMaterielleEnBase.setCode(ressourceMaterielle.getCode());
			ressourceMaterielleEnBase.setCoutUtilisation(ressourceMaterielle.getCoutUtilisation());
			
			if (ressourceMaterielleEnBase.getClass().getSimpleName().equals("Ordinateur")) {

				((Ordinateur) ressourceMaterielleEnBase).setProcesseur(((Ordinateur)ressourceMaterielle).getProcesseur());
				((Ordinateur) ressourceMaterielleEnBase).setRam(((Ordinateur)ressourceMaterielle).getRam());
				((Ordinateur) ressourceMaterielleEnBase).setDisqueDur(((Ordinateur)ressourceMaterielle).getDisqueDur());
				((Ordinateur) ressourceMaterielleEnBase).setAnneeAchat(((Ordinateur)ressourceMaterielle).getAnneeAchat());
				((Ordinateur) ressourceMaterielleEnBase).setStagiaires(((Ordinateur)ressourceMaterielle).getStagiaires());
			
			} else if (ressourceMaterielleEnBase.getClass().getSimpleName().equals("Salle")) {
				((Salle) ressourceMaterielleEnBase).setNbPersonne(((Salle)ressourceMaterielle).getNbPersonne());
				((Salle) ressourceMaterielleEnBase).setCursus(((Salle)ressourceMaterielle).getCursus());
			
			} else if (ressourceMaterielleEnBase.getClass().getSimpleName().equals("VideoProjecteur")) {
				((VideoProjecteur) ressourceMaterielleEnBase).setCursus(((VideoProjecteur)ressourceMaterielle).getCursus());
			}

			ressourceMaterielleRepository.save(ressourceMaterielleEnBase);
			return new ResponseEntity<RessourceMaterielle>(ressourceMaterielleEnBase, HttpStatus.OK);
		} else {
			// pas de ressourceMaterielle
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		ResponseEntity<Void> response = null;
		Optional<RessourceMaterielle> opt = ressourceMaterielleRepository.findById(id);
		if (opt.isPresent()) {
			ressourceMaterielleRepository.delete(opt.get());
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
