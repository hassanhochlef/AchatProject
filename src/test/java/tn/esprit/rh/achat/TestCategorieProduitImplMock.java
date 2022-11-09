package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.verify;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.rh.achat.controllers.converter.CategorieProduitConverter;
import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.controllers.dto.ProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class TestCategorieProduitImplMock {
@Mock
CategorieProduitRepository categorieProduitRepository2;
@InjectMocks
CategorieProduitServiceImpl ctagorieProduitService;
@Autowired
CategorieProduitConverter categorieProduitConverter;
@InjectMocks
CategorieProduitConverter categorieProduitConverter1;
@Autowired 
CategorieProduitRepository categorieProduitRepository;
CategorieProduit cp1 = new CategorieProduit((long) 2,"codeCategorie","libelle",null);

Long getId() {
	for(CategorieProduit cp : categorieProduitRepository.findAll()) {
		return cp.getIdCategorieProduit();
	}
	return 0L;
}
@Test
void Testdeleteecp() {
	
	 categorieProduitRepository2.deleteById((long) 2);
	verify(categorieProduitRepository2,atLeastOnce()).deleteById((long) 2);
}
@Test
void TestAddCategorieProduit() {
	Set<Produit> prods = new HashSet<Produit>();
	CategorieProduit cp = new CategorieProduit((long) 2,"codeCategorie","libelle",prods);
	
	categorieProduitRepository2.save(cp);
	verify(categorieProduitRepository2,atLeastOnce()).save(cp);
	Assertions.assertNotNull(cp);
	System.out.println(cp);
}
@Test

void TestRetrieveCategorieProduit() {
	Optional<CategorieProduit> cp = categorieProduitRepository2.findById((long)2);
	verify(categorieProduitRepository2,atLeastOnce()).findById((long) 2);
	Assertions.assertNotNull(cp);
}

}
