package tn.esprit.rh.achat.controllers.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
@Component
public class ProduitConverter {

	public ProduitDTO convertEntityToDto(Produit produit) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(produit, ProduitDTO.class);
	}
	public Produit convertDtoToEntity(ProduitDTO prodDto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(prodDto, Produit.class);
	}
}
