package tn.esprit.rh.achat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.lenient;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.rh.achat.controllers.converter.CategorieProduitConverter;
import tn.esprit.rh.achat.controllers.dto.CategorieProduitDTO;
import tn.esprit.rh.achat.entities.CategorieProduit;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.CategorieProduitRepository;
import tn.esprit.rh.achat.services.CategorieProduitServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(MockitoExtension.class)
class CategorieProduitImplMock {
@Mock
CategorieProduitRepository categorieProduitRepository;
@InjectMocks
CategorieProduitServiceImpl ctagorieProduitService;
@Autowired
CategorieProduitConverter categorieProduitConverter;
@Autowired
ModelMapper modelMapper;

@Test
void TestAddCategorieProduit() {
	Set<Produit> prods = new HashSet<Produit>();
	CategorieProduit cp = new CategorieProduit((long) 2,"codeCategorie","libelle",prods);
	CategorieProduit c = new CategorieProduit((long)1,"a","b", null);
	lenient().when(categorieProduitRepository.save(Mockito.any(CategorieProduit.class)))
	.thenReturn(c);
	Assertions.assertNotNull(cp);
}
@Test
void TestAddCategorieProduit1() {
	Set<Produit> prods = new HashSet<Produit>();
	CategorieProduit cp = new CategorieProduit((long) 2,"codeCategorie","libelle",prods);
	CategorieProduitDTO cpD = categorieProduitConverter.convertEntityToDto(cp);
ctagorieProduitService.addorUpdateCategorieProduit(cpD);
Assertions.assertNotNull(cp);
}
}
