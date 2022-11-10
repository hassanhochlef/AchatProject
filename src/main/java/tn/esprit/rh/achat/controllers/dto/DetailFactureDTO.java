package tn.esprit.rh.achat.controllers.dto;



import lombok.Data;

@Data
public class DetailFactureDTO {
    private Long idDetailFacture;
    private Integer qteCommandee;
    private float prixTotalDetail;
    private Integer pourcentageRemise;
    private float montantRemise;
}
