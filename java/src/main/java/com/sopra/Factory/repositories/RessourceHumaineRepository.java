package com.sopra.Factory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.Factory.model.RessourceHumaine;

public interface RessourceHumaineRepository extends JpaRepository<RessourceHumaine, Integer>{
	
	@Query("select rh from RessourceHumaine rh left join fetch rh.ordinateur left join fetch rh.cursus left join fetch rh.cursusGeres left join fetch rh.lessons left join fetch rh.matieres ")
	List<RessourceHumaine> findCustomAllRessourceHumaineWithAll();
	
	@Query("select rh from RessourceHumaine rh left join fetch rh.ordinateur left join fetch rh.cursus left join fetch rh.cursusGeres left join fetch rh.lessons left join fetch rh.matieres where rh.id=:idRessourceHumaine")
	Optional<RessourceHumaine> findCustomRessourceHumaineByIdWithAll(@Param("idRessourceHumaine") Integer a);
}
