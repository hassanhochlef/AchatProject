package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

import java.util.List;


public interface ICategorieProduitService {

	List<CategorieProduitDTO> retrieveAllCategorieProduits();

	CategorieProduitDTO addorUpdateCategorieProduit(CategorieProduitDTO cp);

	void deleteCategorieProduit(Long id);

	CategorieProduitDTO retrieveCategorieProduit(Long id);

}
