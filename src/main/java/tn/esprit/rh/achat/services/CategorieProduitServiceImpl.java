package tn.esprit.rh.achat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;

import java.util.List;

@Service
public class CategorieProduitServiceImpl implements ICategorieProduitService {

	
	@Autowired
	CategorieProduitRepository categorieProduitRepository;
	@Override
	public List<CategorieProduitDTO> retrieveAllCategorieProduits() {
		
		return categorieProduitRepository.findAll();
	}

	@Override
	public CategorieProduitDTO addorUpdateCategorieProduit(CategorieProduitDTO cp) {
		categorieProduitRepository.save(cp);
		return cp;
	}

	@Override
	public void deleteCategorieProduit(Long id) {
		categorieProduitRepository.deleteById(id);
		
	}

	

	@Override
	public CategorieProduitDTO retrieveCategorieProduit(Long id) {
		return categorieProduitRepository.findById(id).orElse(null);
	}

}
