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
import com.sopra.Factory.model.Formateur;
import com.sopra.Factory.model.Gestionnaire;
import com.sopra.Factory.model.RessourceHumaine;
import com.sopra.Factory.model.Stagiaire;
import com.sopra.Factory.model.Technicien;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.RessourceHumaineRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/ressourcehumaine")
public class RessourceHumaineRestController {

	@Autowired
	RessourceHumaineRepository ressourceHumaineRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "", "/" })
	public ResponseEntity<List<RessourceHumaine>> findAll() {
		ResponseEntity<List<RessourceHumaine>> response = null;
		response = new ResponseEntity<>(ressourceHumaineRepository.findAll(), HttpStatus.OK);
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@GetMapping(value = "/{id}")
	public ResponseEntity<RessourceHumaine> findById(@PathVariable(name = "id") Integer id) {
		ResponseEntity<RessourceHumaine> response = null;
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(id);
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

	@PostMapping(path = { "/stagiaire", "/stagiaire/" })
	public ResponseEntity<Void> createStagiaire(@Valid @RequestBody Stagiaire stagiaire, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(stagiaire);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(
					uCB.path("rest/ressourcehumaine/stagiaire/{id}").buildAndExpand(stagiaire.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/technicien/", "/technicien" })
	public ResponseEntity<Void> createTechnicien(@Valid @RequestBody Technicien technicien, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(technicien);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(
					uCB.path("rest/ressourcehumaine/technicien/{id}").buildAndExpand(technicien.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/gestionnaire/", "/gestionnaire" })
	public ResponseEntity<Void> createGestionnaire(@Valid @RequestBody Gestionnaire gestionnaire, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(gestionnaire);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/ressourcehumaine/gestionnaire/{id}").buildAndExpand(gestionnaire.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}

	@PostMapping(path = { "/formateur/", "/formateur" })
	public ResponseEntity<Void> createFormateur(@Valid @RequestBody Formateur formateur, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
		} else {
			ressourceHumaineRepository.save(formateur);
			HttpHeaders header = new HttpHeaders();

			header.setLocation(uCB.path("rest/ressourcehumaine/formateur/{id}").buildAndExpand(formateur.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<RessourceHumaine> update(@Valid @RequestBody RessourceHumaine ressourceHumaine,
			BindingResult br) {
		if (br.hasErrors() || ressourceHumaine.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(ressourceHumaine.getId());
		if (opt.isPresent()) {
			// update possible
			RessourceHumaine ressourceHumaineEnBase = opt.get();
			ressourceHumaineEnBase.setNom(ressourceHumaine.getNom());
			ressourceHumaineEnBase.setPrenom(ressourceHumaine.getPrenom());
			ressourceHumaineEnBase.setAdresse(ressourceHumaine.getAdresse());
			ressourceHumaineEnBase.setCoordonnee(ressourceHumaine.getCoordonnee());

			if (ressourceHumaineEnBase.getClass().getSimpleName().equals("Stagiaire")) {

				((Stagiaire) ressourceHumaineEnBase)
						.setProfil(((Stagiaire) ressourceHumaine).getProfil());
				((Stagiaire) ressourceHumaineEnBase).setOrdinateur(((Stagiaire) ressourceHumaine).getOrdinateur());
				((Stagiaire) ressourceHumaineEnBase)
						.setCursus(((Stagiaire) ressourceHumaine).getCursus());
			
			} else if (ressourceHumaineEnBase.getClass().getSimpleName().equals("Technicien")) {
				
			} else if (ressourceHumaineEnBase.getClass().getSimpleName().equals("Gestionnaire")) {
				((Gestionnaire) ressourceHumaineEnBase)
						.setCursusGeres(((Gestionnaire) ressourceHumaine).getCursusGeres());
			
			} else if (ressourceHumaine.getClass().getSimpleName().equals("Formateur")) {
				((Formateur) ressourceHumaineEnBase).setLessons(((Formateur) ressourceHumaine).getLessons());
				((Formateur) ressourceHumaineEnBase).setMatieres(((Formateur) ressourceHumaine).getMatieres());
			}

			ressourceHumaineRepository.save(ressourceHumaineEnBase);
			return new ResponseEntity<RessourceHumaine>(ressourceHumaineEnBase, HttpStatus.OK);
		} else {
			// pas de ressourceMaterielle
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		ResponseEntity<Void> response = null;
		Optional<RessourceHumaine> opt = ressourceHumaineRepository.findById(id);
		if (opt.isPresent()) {
			ressourceHumaineRepository.delete(opt.get());
			response = new ResponseEntity<>(HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
