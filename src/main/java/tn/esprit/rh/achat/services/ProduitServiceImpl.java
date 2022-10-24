package tn.esprit.rh.achat.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.repositories.StockRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Slf4j
public class ProduitServiceImpl implements IProduitService {

	@Autowired
	ProduitRepository produitRepository;
	@Autowired
	StockRepository stockRepository;
	@Autowired
	CategorieProduitRepository categorieProduitRepository;

	@Override
	public List<ProduitDTO> retrieveAllProduits() {
		List<ProduitDTO> produits =  produitRepository.findAll();
		for (ProduitDTO produit : produits) {
			log.info(" Produit : " + produit);
		}
		return produits;
	}

	@Transactional
	public ProduitDTO addProduit(ProduitDTO p) {
		produitRepository.save(p);
		return p;
	}

	

	@Override
	public void deleteProduit(Long produitId) {
		produitRepository.deleteById(produitId);
	}

	@Override
	public ProduitDTO updateProduit(ProduitDTO p) {
		return produitRepository.save(p);
	}

	@Override
	public ProduitDTO retrieveProduit(Long produitId) {
		ProduitDTO produit = produitRepository.findById(produitId).orElse(null);
		log.info("produit :" + produit);
		return produit;
	}

	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		ProduitDTO produit = produitRepository.findById(idProduit).orElse(null);
		if(produit != null) {
		produit.setStockId(idStock);
		produitRepository.save(produit);
		}

	}


}