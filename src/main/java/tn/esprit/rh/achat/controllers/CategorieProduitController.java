
package tn.esprit.rh.achat.controllers;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.services.ICategorieProduitService;

import java.util.List;

@RestController
@Api(tags = "Gestion des categories Produit")
@RequestMapping("/categorieProduit")
public class CategorieProduitController {

	@Autowired
	ICategorieProduitService categorieProduitService;

	@GetMapping("/retrieve-all-categorieProduit")
	@ResponseBody
	public List<CategorieProduit> getCategorieProduit() {
		return categorieProduitService.retrieveAllCategorieProduits();
		
	}

	@GetMapping("/retrieve-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public CategorieProduitDTO retrieveCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		return categorieProduitService.retrieveCategorieProduit(categorieProduitId);
	}

	@PostMapping("/add-categorieProduit")
	@ResponseBody
	public CategorieProduitDTO addCategorieProduit(@RequestBody CategorieProduitDTO cp) {
		return categorieProduitService.addorUpdateCategorieProduit(cp);
		
	}

	
	@DeleteMapping("/remove-categorieProduit/{categorieProduit-id}")
	@ResponseBody
	public void removeCategorieProduit(@PathVariable("categorieProduit-id") Long categorieProduitId) {
		categorieProduitService.deleteCategorieProduit(categorieProduitId);
	}

	@PutMapping("/modify-categorieProduit")
	@ResponseBody
	public CategorieProduitDTO modifyCategorieProduit(@RequestBody CategorieProduitDTO categorieProduit) {
		return categorieProduitService.addorUpdateCategorieProduit(categorieProduit);
	}

	
}
