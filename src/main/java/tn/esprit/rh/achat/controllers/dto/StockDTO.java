package tn.esprit.rh.achat.controllers.dto;



import lombok.Data;

@Data
public class StockDTO {
    private Long idStock;
    private String libelleStock;
    private Integer qte;
    private Integer qteMin;
}
