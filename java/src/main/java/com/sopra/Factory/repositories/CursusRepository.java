package com.sopra.Factory.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sopra.Factory.model.Cursus;

public interface CursusRepository extends JpaRepository<Cursus, Integer> {
	
	@Query("select c from Cursus c left join fetch c.salle left join fetch c.videoProjecteur left join fetch c.stagiaires left join fetch c.gestionnaire left join fetch c.lessons ")
	List<Cursus> findCustomAllWithAll();
	
	@Query("select c from Cursus c left join fetch c.salle left join fetch c.videoProjecteur left join fetch c.stagiaires left join fetch c.gestionnaire left join fetch c.lessons where c.id=:idCursus")
	Optional<Cursus> findCustomByIdWithAll(@Param("idCursus") Integer a);

}
