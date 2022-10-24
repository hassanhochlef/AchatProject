package tn.esprit.rh.achat.controllers.converter;

import org.modelmapper.ModelMapper;
import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;

public class ProduitConverter {
	public ProduitDTO convertEntityToDto(Produit produit) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(produit, ProduitDTO.class);
	}
}
