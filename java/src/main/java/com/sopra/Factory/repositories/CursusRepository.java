package com.sopra.Factory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.Factory.model.Cursus;

public interface CursusRepository extends JpaRepository<Cursus, Integer> {

}
