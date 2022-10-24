package tn.esprit.rh.achat.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

@Repository
public interface CategorieProduitRepository extends JpaRepository<CategorieProduitDTO, Long>{

}
