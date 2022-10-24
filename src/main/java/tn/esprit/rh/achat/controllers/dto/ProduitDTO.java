package tn.esprit.rh.achat.controllers.dto;

import java.util.Date;
import java.util.Set;
import lombok.Data;
import tn.esprit.rh.achat.entities.DetailFacture;
@Data
public class ProduitDTO {
	private Long idProduit;
	private String codeProduit;
	private String libelleProduit;
	private float prix;
	private Date dateCreation;
	private Date dateDerniereModification;
	private long stockId;
	private Set<DetailFacture> detailFacture;
	private long categorieProduitId;
}
