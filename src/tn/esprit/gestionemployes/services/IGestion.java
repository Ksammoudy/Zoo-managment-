package tn.esprit.gestionemployes.services;

import tn.esprit.gestionemployes.exceptions.ElementDejaExistantException;
import tn.esprit.gestionemployes.exceptions.ElementInexistantException;

import java.util.List;

public interface IGestion<T> {

    void ajouter(T t) throws ElementDejaExistantException;

    void supprimer(T t) throws ElementInexistantException;

    boolean rechercher(T t);

    void afficher();

    List<T> trier();
}
