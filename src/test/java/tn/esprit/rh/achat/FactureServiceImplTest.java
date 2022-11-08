package tn.esprit.rh.achat;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.text.ParseException;



import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Facture;

import tn.esprit.rh.achat.services.IFactureService;
import tn.esprit.rh.achat.services.IFournisseurService;
import tn.esprit.rh.achat.services.IOperateurService;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FactureServiceImplTest {
    @Autowired
    IFactureService factureService;
    @Autowired

    IOperateurService operateurService;
    @Autowired
    IFournisseurService fournisseurService;



    @Test
    public void testAddFacture () throws  ParseException  {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        System.out.print("client "+savedFactrure);
        assertNotNull(savedFactrure);
        Assertions.assertEquals(200f, savedFactrure.getMontantFacture());
        Assertions.assertEquals(20f,savedFactrure.getMontantRemise());
        assertEquals(new Date(10 / 10 / 2022),savedFactrure.getDateCreationFacture());
        factureService.cancelFacture(savedFactrure.getIdFacture());
        log.info("facture ajoutée ===>" + savedFactrure);

    }

    @Test
    public void testCancelFacture() throws  ParseException  {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFacture= factureService.addFacture(f);
        factureService.cancelFacture(savedFacture.getIdFacture());
        assertEquals(true,savedFacture.getArchivee());
    }
    @Test
    public void testRetrieveAllFactures() throws ParseException {
        List<Facture> factures =  factureService.retrieveAllFactures();
        int expected =factures.size();
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        assertEquals(expected + 1,factureService.retrieveAllFactures().size());
        factureService.cancelFacture(savedFactrure.getIdFacture());
    }
    @Test
    public void testRetrieveFacturesById() throws ParseException {
        Facture f = new Facture(20f,200f, new Date(10 / 10 / 2020),new Date(10 / 10 / 2022), true);
        Facture savedFactrure= factureService.addFacture(f);
        Assertions.assertEquals(200f, savedFactrure.getMontantFacture());
        Assertions.assertEquals(20f,savedFactrure.getMontantRemise());
        assertEquals(new Date(10 / 10 / 2022),savedFactrure.getDateCreationFacture());
        log.info("get ===>" + factureService.toString());
    }
}
