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
import com.sopra.Factory.model.Lesson;
import com.sopra.Factory.model.view.JsonViews;
import com.sopra.Factory.repositories.LessonRepository;

@CrossOrigin(origins = { "*" })
@RestController
@RequestMapping("/rest/lesson")
public class LessonRestController {

	@Autowired
	LessonRepository lessonRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(path = { "/", "" })
	public ResponseEntity<List<Lesson>> findAll() {
		return new ResponseEntity<>(lessonRepository.findAll(), HttpStatus.OK);
	}

	@PostMapping(path = { "/", "" })
	public ResponseEntity<Void> createLesson(@Valid @RequestBody Lesson lesson, BindingResult br,
			UriComponentsBuilder uCB) {
		ResponseEntity<Void> response = null;
		if (br.hasErrors()) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			lessonRepository.save(lesson);
		HttpHeaders header = new HttpHeaders();
		header.setLocation(uCB.path("/rest/lesson/{id}").buildAndExpand(lesson.getId()).toUri());
			response = new ResponseEntity<Void>( HttpStatus.CREATED);
		}
		return response;
	}

	@GetMapping(value = "/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Lesson> findById(@PathVariable(name = "id") Integer id) {
		Optional<Lesson> opt = lessonRepository.findById(id);
		ResponseEntity<Lesson> response = null;
		if (opt.isPresent()) {
			response = new ResponseEntity<>(opt.get(), HttpStatus.OK);
		} else {
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return response;
	}

	@JsonView(JsonViews.Common.class)
	@PutMapping(path = { "/", "" })
	public ResponseEntity<Lesson> update(@Valid @RequestBody Lesson lesson, BindingResult br) {
		if (br.hasErrors() || lesson.getId() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		Optional<Lesson> opt = lessonRepository.findById(lesson.getId());
		if (opt.isPresent()) {
			// update possible
			Lesson lessonEnBase = opt.get();
			lessonEnBase.setDateDebut(lesson.getDateDebut());
			lessonEnBase.setDateFin(lesson.getDateFin());
			lessonEnBase.setFormateur(lesson.getFormateur());
			lessonEnBase.setMatiere(lesson.getMatiere());
			lessonEnBase.setCursus(lesson.getCursus());
			
			lessonRepository.save(lessonEnBase);
			return new ResponseEntity<Lesson>(lessonEnBase, HttpStatus.OK);
		} else {
			// pas de lesson
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name = "id") Integer id) {
		Optional<Lesson> opt = lessonRepository.findById(id);
		ResponseEntity<Void> response = null;
		if (opt.isPresent()) {
			lessonRepository.deleteById(id);
			response = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return response;
	}

}
