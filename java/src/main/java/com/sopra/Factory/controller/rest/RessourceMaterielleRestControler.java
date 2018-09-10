package com.sopra.Factory.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sopra.Factory.model.Ordinateur;
import com.sopra.Factory.model.RessourceMaterielle;
import com.sopra.Factory.model.Salle;
import com.sopra.Factory.model.VideoProjecteur;
import com.sopra.Factory.repositories.RessourceMaterielleRepository;

@RestController
@RequestMapping("/rest/ressource/materielle")
public class RessourceMaterielleRestControler {

	@Autowired
	RessourceMaterielleRepository ressourceMaterielleRepository;

	@GetMapping(path = { "", "/" })
	public ResponseEntity<List<RessourceMaterielle>> findAll() {
		ResponseEntity<List<RessourceMaterielle>> response = null;
		response = new ResponseEntity<>(ressourceMaterielleRepository.findAll(), HttpStatus.OK);
		return response;
	}

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

	@PostMapping(path = { "/ordinateur", "" })
	public ResponseEntity<Void> createOrdinateur(@Valid @RequestBody Ordinateur ordinateur, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(ordinateur);
			// HttpHeaders header = new HttpHeaders();

			// header.setLocation(uCB.path("rest/ordinateur/{id}").buildAndExpand(ordinateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/projecteur", "" })
	public ResponseEntity<Void> createVideoProjecteur(@Valid @RequestBody VideoProjecteur videoProjecteur,
			BindingResult br, UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(videoProjecteur);
			// HttpHeaders header = new HttpHeaders();

			// header.setLocation(uCB.path("rest/projecteur/{id}").buildAndExpand(videoProjecteur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/salle", "" })
	public ResponseEntity<Void> createSalle(@Valid @RequestBody Salle salle, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceMaterielleRepository.save(salle);
			// HttpHeaders header = new HttpHeaders();

			// header.setLocation(uCB.path("rest/salle/{id}").buildAndExpand(ordinateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
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
			
			if (RessourceMaterielle.class.getSimpleName() == "Ordinateur") {

				((Ordinateur) ressourceMaterielleEnBase).setProcesseur(((Ordinateur)ressourceMaterielle).getProcesseur());
				((Ordinateur) ressourceMaterielleEnBase).setRam(((Ordinateur)ressourceMaterielle).getRam());
				((Ordinateur) ressourceMaterielleEnBase).setDisqueDur(((Ordinateur)ressourceMaterielle).getDisqueDur());
				((Ordinateur) ressourceMaterielleEnBase).setAnneeAchat(((Ordinateur)ressourceMaterielle).getAnneeAchat());
	//			((Ordinateur) ressourceMaterielleEnBase).setStagiaires(((Ordinateur)ressourceMaterielle).getStagiaires());
			} else if (RessourceMaterielle.class.getSimpleName() == "Salle") {
				((Salle) ressourceMaterielleEnBase).setNbPersonne(((Salle)ressourceMaterielle).getNbPersonne());
				((Salle) ressourceMaterielleEnBase).setCursus(((Salle)ressourceMaterielle).getCursus());
			} else if (RessourceMaterielle.class.getSimpleName() == "VideoProjecteur") {
				((VideoProjecteur) ressourceMaterielleEnBase).setCursus(((VideoProjecteur)ressourceMaterielle).getCursus());
			}

			ressourceMaterielleRepository.save(ressourceMaterielleEnBase);
			return new ResponseEntity<RessourceMaterielle>(ressourceMaterielleEnBase, HttpStatus.OK);
		} else {
			// pas de client
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
