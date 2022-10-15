package tn.esprit.rh.achat.services;

import tn.esprit.rh.achat.entities.Operateur;

import java.util.List;


public interface IOperateurService {

	List<Operateur> retrieveAllOperateurs();

	void deleteOperateur(Long id);

	Operateur addUpdateOperateur(Operateur o);

	Operateur retrieveOperateur(Long id);

}
