package tn.esprit.rh.achat.controllers.converter;

import org.modelmapper.ModelMapper;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;

public class CategorieProduitConverter {
public CategorieProduitDTO convertEntityToDto(CategorieProduit categorieProduit) {
	ModelMapper modelMapper = new ModelMapper();
	return modelMapper.map(categorieProduit, CategorieProduitDTO.class);
}
}
