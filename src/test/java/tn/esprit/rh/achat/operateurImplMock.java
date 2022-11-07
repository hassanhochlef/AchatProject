package tn.esprit.rh.achat;

import static org.mockito.Mockito.lenient;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Facture;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
public class operateurImplMock {
	@Mock
	OperateurRepository or;
	@InjectMocks
	OperateurServiceImpl os;
	@Test
	void TestAddOperateur() {
		Set<Facture> f = new HashSet<Facture>();
		Operateur op = new Operateur((long) 2,"codeCategorie","libelle","123",f);
		Operateur c = new Operateur((long) 2,"codeCategorie","libelle","123",null);
		lenient().when(or.save(Mockito.any(Operateur.class)))
		.thenReturn(c);
		Assertions.assertNotNull(op);
	}
}
