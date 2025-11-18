package tn.esprit.gestionemployes.services;

import tn.esprit.gestionemployes.entities.Employe;
import tn.esprit.gestionemployes.exceptions.ElementDejaExistantException;
import tn.esprit.gestionemployes.exceptions.ElementInexistantException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe> {

    private List<Employe> employes;

    public SocieteArrayList() {
        this.employes = new ArrayList<>();
    }

    @Override
    public void ajouter(Employe e) throws ElementDejaExistantException {
        if (employes.contains(e)) {
            throw new ElementDejaExistantException(
                    "Employé avec id " + e.getId() + " existe déjà !");
        }
        employes.add(e);
    }

    @Override
    public void supprimer(Employe e) throws ElementInexistantException {
        if (!employes.remove(e)) {
            throw new ElementInexistantException(
                    "Employé avec id " + e.getId() + " introuvable, suppression impossible.");
        }
    }

    @Override
    public boolean rechercher(Employe e) {
        return employes.contains(e);
    }

    // Recherche par nom (méthode supplémentaire utile)
    public boolean rechercherEmploye(String nom) {
        for (Employe e : employes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void afficher() {
        if (employes.isEmpty()) {
            System.out.println("Aucun employé dans la société.");
            return;
        }
        for (Employe e : employes) {
            System.out.println(e);
        }
    }

    @Override
    public List<Employe> trier() {
        List<Employe> copie = new ArrayList<>(employes);
        // Tri par id
        Collections.sort(copie, Comparator.comparingInt(Employe::getId));
        return copie;
    }

    // Tri spécifique : par département puis grade
    public List<Employe> trierParDepartementPuisGrade() {
        List<Employe> copie = new ArrayList<>(employes);
        copie.sort(
                Comparator.comparing(Employe::getDepartement)
                        .thenComparingInt(Employe::getGrade)
        );
        return copie;
    }

    // Pour le prosit 9, tu peux garder ta méthode displayEmploye() en plus si tu veux
    public void displayEmploye() {
        afficher();
    }
}
