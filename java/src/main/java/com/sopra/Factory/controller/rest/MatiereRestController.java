package com.sopra.Factory.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.sopra.Factory.model.Matiere;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.MatiereRepository;

@CrossOrigin(origins= {"*"})
@RestController
@RequestMapping("/rest/matiere")
public class MatiereRestController {

	@Autowired
	MatiereRepository matiereRepository;

	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Matiere>> findAll() {
		return new ResponseEntity<>(matiereRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createMatiere(@Valid @RequestBody Matiere matiere, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			matiereRepository.save(matiere);
			// HttpHeaders header = new HttpHeaders();
			// header.setLocation(uCB.path("/rest/matiere/{id}").buildAndExpand(matiere.getId()).toUri());
			response = new ResponseEntity<Void>(HttpStatus.CREATED); // ,header);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Matiere> findById(@PathVariable(name = "id") Integer id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		ResponseEntity<Matiere> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Matiere> update(@Valid @RequestBody Matiere matiere, BindingResult br) {
		if (br.hasErrors() || matiere.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Matiere> opt = matiereRepository.findById(matiere.getId());
		if (opt.isPresent()) {
			// update possible
			Matiere matiereEnBase = opt.get();
			matiereEnBase.setContenu(matiere.getContenu());
			matiereEnBase.setDuree(matiere.getDuree());
			matiereEnBase.setFormateurs(matiere.getFormateurs());
			matiereEnBase.setLessons(matiere.getLessons());
			matiereEnBase.setNiveau(matiere.getNiveau());
			matiereEnBase.setObjectif(matiere.getObjectif());
			matiereEnBase.setPrerequis(matiere.getPrerequis());
			matiereRepository.save(matiereEnBase);
			return new ResponseEntity<Matiere>(matiereEnBase, HttpStatus.OK);
		} else {
			// pas de matiere
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Matiere> opt = matiereRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			matiereRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
