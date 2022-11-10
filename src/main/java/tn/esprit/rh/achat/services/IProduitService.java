package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;

import java.util.List;

public interface IProduitService {

	List<Produit> retrieveAllProduits();

	ProduitDTO addUpdateProduit(ProduitDTO p);

	void deleteProduit(Long id);


	ProduitDTO retrieveProduit(Long id);

	void assignProduitToStock(Long idProduit, Long idStock);

}
