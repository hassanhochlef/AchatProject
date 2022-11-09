package tn.esprit.rh.achat.controllers.converter;


import org.modelmapper.ModelMapper;
import tn.esprit.rh.achat.controllers.dto.FactureDTO;
import tn.esprit.rh.achat.entities.Facture;

public class FactureConverter {
    public FactureDTO convertEntityToDto(Facture facture) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(facture, FactureDTO.class);
    }
    public Facture convertDtoToEntity(Facture factureDto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(factureDto, Facture.class);
    }
}
