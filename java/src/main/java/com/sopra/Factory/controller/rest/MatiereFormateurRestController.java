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
import com.sopra.Factory.model.MatiereFormateur;
import com.sopra.Factory.model.MatiereFormateurPK;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.MatiereFormateurRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/matiereformateur")
public class MatiereFormateurRestController {

	@Autowired
	MatiereFormateurRepository matiereFormateurRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<MatiereFormateur>> findAll() {
		return new ResponseEntity<>(matiereFormateurRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createMatiereFormateur(@Valid @RequestBody MatiereFormateur matiereFormateur, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereFormateurRepository.save(matiereFormateur);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uCB.path("/rest/matiereformateur/{id}").buildAndExpand(matiereFormateur.getKey()).toUri());
			response = new ResponseEntity<Void>( HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{key}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<MatiereFormateur> findById(@PathVariable(name = "key") MatiereFormateurPK key) {
		Optional<MatiereFormateur> opt = matiereFormateurRepository.findById(key);
		ResponseEntity<MatiereFormateur> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<MatiereFormateur> update(@Valid @RequestBody MatiereFormateur matiereFormateur, BindingResult br) {
		if (br.hasErrors() || matiereFormateur.getKey() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<MatiereFormateur> opt = matiereFormateurRepository.findById(matiereFormateur.getKey());
		if (opt.isPresent()) {
			// update possible
			MatiereFormateur matiereFormateurEnBase = opt.get();
			return new ResponseEntity<MatiereFormateur>(matiereFormateurEnBase, HttpStatus.OK);
		} else {
			// pas de cursus
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{key}")
	public ResponseEntity<Void> delete(@PathVariable(name = "key") MatiereFormateurPK key) {
		Optional<MatiereFormateur> opt = matiereFormateurRepository.findById(key);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			matiereFormateurRepository.deleteById(key);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
