package com.sopra.Factory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.Factory.model.Stagiaire;

public interface StagiaireRepository extends JpaRepository<Stagiaire, Integer>{
	@Query("select s from Stagiaire s left join fetch s.ordinateur left join fetch s.cursus left join fetch s.adresse left join fetch s.coordonnee ")
	List<Stagiaire> findCustomAllStagiaireWithAll();
	
	@Query("select s from Stagiaire s left join fetch s.ordinateur left join fetch s.cursus left join fetch s.adresse left join fetch s.coordonnee where s.id=:idStagiaire")
	Optional<Stagiaire> findCustomStagiaireByIdWithAll(@Param("idStagiaire") Integer a);
}
