package tn.esprit.rh.achat.controllers.converter;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import tn.esprit.rh.achat.controllers.dto.FournisseurDTO;
import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.entities.Produit;

@Component
public class FournisseurConverter {
    public FournisseurDTO convertEntityToDto(Fournisseur fournisseur) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(fournisseur, FournisseurDTO.class);
    }
    public Fournisseur convertDtoToEntity(FournisseurDTO forDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(forDto, Fournisseur.class);
    }
}
