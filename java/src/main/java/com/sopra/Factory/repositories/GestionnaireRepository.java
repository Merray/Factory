package com.sopra.Factory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.Factory.model.Gestionnaire;

public interface GestionnaireRepository extends JpaRepository<Gestionnaire, Integer>{
	@Query("select g from Gestionnaire g left join fetch g.cursusGeres left join fetch g.adresse left join fetch g.coordonnee ")
	List<Gestionnaire> findCustomAllGestionnaireWithAll();
	
	@Query("select g from Gestionnaire g left join fetch g.cursusGeres left join fetch g.adresse left join fetch g.coordonnee where g.id=:idGestionnaire")
	Optional<Gestionnaire> findCustomGestionnaireByIdWithAll(@Param("idGestionnaire") Integer a);
}
