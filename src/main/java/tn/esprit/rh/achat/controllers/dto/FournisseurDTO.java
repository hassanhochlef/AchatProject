package tn.esprit.rh.achat.controllers.dto;

import lombok.Data;
import tn.esprit.rh.achat.entities.CategorieFournisseur;
import tn.esprit.rh.achat.entities.DetailFournisseur;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.SecteurActivite;

import javax.persistence.*;
import java.util.Set;

@Data
public class FournisseurDTO {
    private Long idFournisseur;
    private String code;
    private String libelle;
    @Enumerated(EnumType.STRING)
    private CategorieFournisseur categorieFournisseur;

    private Set<Facture> factures;

    private Set<SecteurActivite> secteurActivites;

    private DetailFournisseur detailFournisseur;

}
