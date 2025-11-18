package tn.esprit.gestionemployes.entities;

import java.util.HashSet;
import java.util.TreeSet;
import java.util.Comparator;

public class DepartementHashSet implements IDepartement<Departement> {

    private HashSet<Departement> departements;

    public DepartementHashSet() {
        departements = new HashSet<>();
    }

    @Override
    public void ajouterDepartement(Departement d) {
        if (departements.add(d)) {
            System.out.println("✅ Département ajouté : " + d.getNom());
        } else {
            System.out.println("⚠️ Département déjà existant : " + d.getNom());
        }
    }

    @Override
    public boolean rechercherDepartement(String nom) {
        for (Departement d : departements) {
            if (d.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherDepartement(Departement d) {
        return departements.contains(d);
    }

    @Override
    public void supprimerDepartement(Departement d) {
        if (departements.remove(d)) {
            System.out.println("️ Département supprimé : " + d.getNom());
        } else {
            System.out.println("  Département introuvable !");
        }
    }

    @Override
    public void displayDepartement() {
        System.out.println("📋 Liste des départements :");
        for (Departement d : departements) {
            System.out.println(d);
        }
    }

    @Override
    public TreeSet<Departement> trierDepartementById() {
        TreeSet<Departement> sorted = new TreeSet<>(Comparator.comparingInt(Departement::getId));
        sorted.addAll(departements);
        return sorted;
    }
}
