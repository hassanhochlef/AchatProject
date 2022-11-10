package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.controllers.converter.ProduitConverter;
import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.services.IProduitService;

import java.util.List;


@RestController
@Api(tags = "Gestion des produits")
@RequestMapping("/produit")
public class ProduitRestController {

	@Autowired
	IProduitService produitService;
	@Autowired
	ProduitConverter produitConverter;
	@GetMapping("/retrieve-all-produits")
	@ResponseBody
	public List<Produit> getProduits() {
		return produitService.retrieveAllProduits();
		
	}


	@GetMapping("/retrieve-produit/{produit-id}")
	@ResponseBody
	public ProduitDTO retrieveRayon(@PathVariable("produit-id") Long produitId) {
		return produitService.retrieveProduit(produitId);
	}

	
	@PostMapping("/add-produit")
	@ResponseBody
	public ProduitDTO addProduit(@RequestBody ProduitDTO p) {
		return  produitService.addUpdateProduit(p);
	}

	
	@DeleteMapping("/remove-produit/{produit-id}")
	@ResponseBody
	public void removeProduit(@PathVariable("produit-id") Long produitId) {
		produitService.deleteProduit(produitId);
	}

	
	@PutMapping("/modify-produit")
	@ResponseBody
	public ProduitDTO modifyProduit(@RequestBody ProduitDTO p) {
		return produitService.addUpdateProduit(p);
	}

	@PutMapping(value = "/assignProduitToStock/{idProduit}/{idStock}")
	public void assignProduitToStock(@PathVariable("idProduit") Long idProduit, @PathVariable("idStock") Long idStock) {
		produitService.assignProduitToStock(idProduit, idStock);
	}



}
