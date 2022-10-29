package tn.esprit.rh.achat.controllers.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
@Component
public class CategorieProduitConverter {
public CategorieProduitDTO convertEntityToDto(CategorieProduit categorieProduit) {
	ModelMapper modelMapper = new ModelMapper();
	return modelMapper.map(categorieProduit, CategorieProduitDTO.class);
}
public CategorieProduit convertDtoToEntity(CategorieProduitDTO categorieProduitDto) {
	ModelMapper modelMapper = new ModelMapper();
	CategorieProduit categorieProduit = modelMapper.map(categorieProduitDto, CategorieProduit.class);
	return categorieProduit;
}
}
