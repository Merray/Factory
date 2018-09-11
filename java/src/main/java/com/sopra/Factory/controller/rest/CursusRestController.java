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

import com.fasterxml.jackson.annotation.JsonView;
import com.sopra.Factory.model.Cursus;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.CursusRepository;

@RestController
@RequestMapping("/rest/cursus")
public class CursusRestController {

	@Autowired
	CursusRepository cursusRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Cursus>> findAll() {
		return new ResponseEntity<>(cursusRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createCursus(@Valid @RequestBody Cursus cursus, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			cursusRepository.save(cursus);
		//	HttpHeaders header = new HttpHeaders();
		//	header.setLocation(uCB.path("/rest/cursus/{id}").buildAndExpand(cursus.getId()).toUri());
			response = new ResponseEntity<Void>( HttpStatus.CREATED); //,header);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Cursus> findById(@PathVariable(name = "id") Integer id) {
		Optional<Cursus> opt = cursusRepository.findById(id);
		ResponseEntity<Cursus> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Cursus> update(@Valid @RequestBody Cursus cursus, BindingResult br) {
		if (br.hasErrors() || cursus.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Cursus> opt = cursusRepository.findById(cursus.getId());
		if (opt.isPresent()) {
			// update possible
			Cursus cursusEnBase = opt.get();
			cursusEnBase.setDateDebut(cursus.getDateDebut());
			cursusEnBase.setDateFin(cursus.getDateFin());
			cursusEnBase.setGestionnaire(cursus.getGestionnaire());
			cursusEnBase.setLessons(cursus.getLessons());
			cursusEnBase.setNbStagiaire(cursus.getNbStagiaire());
			cursusEnBase.setSalle(cursus.getSalle());
			cursusEnBase.setStagiaires(cursus.getStagiaires());
			cursusEnBase.setVideoProjecteur(cursus.getVideoProjecteur());
			cursusRepository.save(cursusEnBase);
			return new ResponseEntity<Cursus>(cursusEnBase, HttpStatus.OK);
		} else {
			// pas de cursus
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Cursus> opt = cursusRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			cursusRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
