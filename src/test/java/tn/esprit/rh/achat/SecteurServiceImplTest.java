package tn.esprit.rh.achat;
import org.junit.Test;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.rh.achat.entities.SecteurActivite;
import tn.esprit.rh.achat.services.ISecteurActiviteService;

import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SecteurServiceImplTest {
    @Autowired
    ISecteurActiviteService secteurActiviteService;


    @Test
    public void testAddSecteurActivite() throws ParseException {
        SecteurActivite s = new SecteurActivite(null,"test","test",null);
        SecteurActivite secteurActivite = secteurActiviteService.addSecteurActivite(s);
        System.out.print("secteurActivite "+secteurActivite);
        assertNotNull(secteurActivite.getIdSecteurActivite());
        assertTrue(secteurActivite.getCodeSecteurActivite().length() > 0);
        secteurActiviteService.deleteSecteurActivite(secteurActivite.getIdSecteurActivite());
    }



    @Test
    public void testDeleteSecteurActivite() throws ParseException {
        SecteurActivite s = new SecteurActivite(null,"test","test",null);
        secteurActiviteService.deleteSecteurActivite((long) 1);;
        secteurActiviteService.deleteSecteurActivite( s.getIdSecteurActivite());
        assertNull(secteurActiviteService.retrieveSecteurActivite(s.getIdSecteurActivite()));
    }



    @Test
    public void testRetrieveAllSecteurs() throws ParseException {
        List<SecteurActivite> secteurActivites = secteurActiviteService.retrieveAllSecteurActivite();
        int expected =secteurActivites.size();
        SecteurActivite s = new SecteurActivite(null,"test","test",null);

        SecteurActivite secteurActivite= secteurActiviteService.retrieveSecteurActivite(s.getIdSecteurActivite());
        assertEquals(expected + 1, secteurActiviteService.retrieveAllSecteurActivite().size());
        secteurActiviteService.deleteSecteurActivite(secteurActivite.getIdSecteurActivite());
    }

}