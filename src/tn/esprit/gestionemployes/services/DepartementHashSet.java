package tn.esprit.gestionemployes.services;

import tn.esprit.gestionemployes.entities.Departement;
import tn.esprit.gestionemployes.exceptions.ElementDejaExistantException;
import tn.esprit.gestionemployes.exceptions.ElementInexistantException;

import java.util.*;

public class DepartementHashSet implements IGestion<Departement> {

    private Set<Departement> departements;

    public DepartementHashSet() {
        this.departements = new HashSet<>();
    }

    @Override
    public void ajouter(Departement d) throws ElementDejaExistantException {
        if (departements.contains(d)) {
            throw new ElementDejaExistantException(
                    "Département avec id " + d.getId() + " existe déjà !");
        }
        departements.add(d);
    }

    @Override
    public void supprimer(Departement d) throws ElementInexistantException {
        if (!departements.remove(d)) {
            throw new ElementInexistantException(
                    "Département avec id " + d.getId() + " introuvable, suppression impossible.");
        }
    }

    @Override
    public boolean rechercher(Departement d) {
        return departements.contains(d);
    }

    // Recherche par nom
    public boolean rechercherDepartement(String nom) {
        for (Departement d : departements) {
            if (d.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void afficher() {
        if (departements.isEmpty()) {
            System.out.println("Aucun département.");
            return;
        }
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    @Override
    public List<Departement> trier() {
        List<Departement> liste = new ArrayList<>(departements);
        liste.sort(Comparator.comparingInt(Departement::getId));
        return liste;
    }

    // Pour rester compatible avec ton ancien code
    public void displayDepartement() {
        afficher();
    }

    public Set<Departement> trierDepartementById() {
        // version Set trié
        return new TreeSet<>(Comparator.comparingInt(Departement::getId));
    }
}
