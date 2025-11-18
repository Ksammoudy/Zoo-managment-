package tn.esprit.gestionemployes.entities;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Comparator;

public class AffectationHashMap {

    private Map<Employe, Departement> affectations;

    public AffectationHashMap() {
        this.affectations = new HashMap<>();
    }

    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affectations.put(e, d);
    }

    public void afficherEmployesEtDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucune affectation pour le moment.");
            return;
        }
        for (Map.Entry<Employe, Departement> entry : affectations.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public void supprimerEmploye(Employe e) {
        affectations.remove(e);
    }

    public void supprimerEmployeEtDepartement(Employe e, Departement d) {
        if (affectations.containsKey(e) && affectations.get(e).equals(d)) {
            affectations.remove(e);
        }
    }

    public void afficherEmployes() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun employé affecté.");
            return;
        }
        System.out.println("Liste des employés :");
        for (Employe e : affectations.keySet()) {
            System.out.println(e);
        }
    }

    public void afficherDepartements() {
        if (affectations.isEmpty()) {
            System.out.println("Aucun département enregistré.");
            return;
        }
        Set<Departement> deps = new HashSet<>(affectations.values());
        System.out.println("Liste des départements :");
        for (Departement d : deps) {
            System.out.println(d);
        }
    }

    public boolean rechercherEmploye(Employe e) {
        return affectations.containsKey(e);
    }

    public boolean rechercherDepartement(Departement d) {
        return affectations.containsValue(d);
    }

    public TreeMap<Employe, Departement> trierMap() {
        TreeMap<Employe, Departement> sorted =
                new TreeMap<>(Comparator.comparingInt(Employe::getId));
        sorted.putAll(affectations);
        return sorted;
    }
}
