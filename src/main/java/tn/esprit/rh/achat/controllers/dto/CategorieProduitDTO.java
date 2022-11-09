package tn.esprit.rh.achat.controllers.dto;

import java.util.Set;

import lombok.Data;
import tn.esprit.rh.achat.entities.Produit;

@Data
public class CategorieProduitDTO {
	private Long idCategorieProduit;
	private String codeCategorie;
	private String libelleCategorie;
	private Set<Produit> produits;
	
}
