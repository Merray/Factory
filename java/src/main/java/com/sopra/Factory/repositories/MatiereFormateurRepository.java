package com.sopra.Factory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sopra.Factory.model.MatiereFormateur;
import com.sopra.Factory.model.MatiereFormateurPK;

public interface MatiereFormateurRepository extends JpaRepository<MatiereFormateur, MatiereFormateurPK>{

}
