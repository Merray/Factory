package com.sopra.Factory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.Factory.model.Formateur;
import com.sopra.Factory.model.Gestionnaire;

public interface FormateurRepository extends JpaRepository<Formateur, Integer> {
	@Query("select f from Formateur f left join fetch f.lessons left join fetch f.matieres left join fetch f.adresse left join fetch f.coordonnee ")
	List<Formateur> findCustomAllFormateurWithAll();
	
	@Query("select f from Formateur f left join fetch f.lessons left join fetch f.matieres left join fetch f.adresse left join fetch f.coordonnee where f.id=:idFormateur")
	Optional<Formateur> findCustomFormateurByIdWithAll(@Param("idFormateur") Integer a);
}
