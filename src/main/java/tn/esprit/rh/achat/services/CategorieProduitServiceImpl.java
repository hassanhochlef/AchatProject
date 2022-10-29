package tn.esprit.rh.achat.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.controllers.converter.CategorieProduitConverter;
import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	@Autowired
	ModelMapper modelMapper;
	@Autowired
	CategorieProduitConverter categorieProduitConverter;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduit> retrieveAllCategorieProduits() {
		return categorieProduitRepository.findAll();
		
	}

	@Override
	public CategorieProduitDTO addorUpdateCategorieProduit(CategorieProduitDTO cpdto) {
		CategorieProduit cp = categorieProduitConverter.convertDtoToEntity(cpdto);
		cp = categorieProduitRepository.save(cp);
		return categorieProduitConverter.convertEntityToDto(cp);
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	

	@Override
	public CategorieProduitDTO retrieveCategorieProduit(Long id) {
		CategorieProduit c = categorieProduitRepository.findById(id).orElse(null);
		return categorieProduitConverter.convertEntityToDto(c);
	}

}
