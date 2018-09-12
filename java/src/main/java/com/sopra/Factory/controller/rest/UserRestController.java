package com.sopra.Factory.controller.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sopra.Factory.model.User;
import com.sopra.Factory.repositories.UsersRepository;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/rest/login")
public class UserRestController {
@Autowired
private UsersRepository userRepository;


	@PostMapping(path = {"/", ""})
    public ResponseEntity<Void> createLogin(@Valid @RequestBody User user, BindingResult br, UriComponentsBuilder uCB) {
        ResponseEntity<Void> response = null;
        if(br.hasErrors()) {
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else {
        	user.setPassword(getPasswordEncoder().encode(user.getPassword()));
            userRepository.save(user);
            HttpHeaders header = new HttpHeaders();
            header.setLocation(uCB.path("/rest/user/technicien/{id}").buildAndExpand(user.getUsername()).toUri());
            response = new ResponseEntity<Void>(HttpStatus.CREATED);
        }
        return response;
    }
@Bean
public PasswordEncoder getPasswordEncoder() {
    return new BCryptPasswordEncoder();
}
}

