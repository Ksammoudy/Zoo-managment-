package tn.esprit.gestionemployes.main;

import tn.esprit.gestionemployes.entities.AffectationHashMap;
import tn.esprit.gestionemployes.entities.Departement;
import tn.esprit.gestionemployes.entities.Employe;
import tn.esprit.gestionemployes.exceptions.ElementDejaExistantException;
import tn.esprit.gestionemployes.exceptions.ElementInexistantException;
import tn.esprit.gestionemployes.services.SocieteArrayList;
import tn.esprit.gestionemployes.services.DepartementHashSet;

import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        // ===== Prosit 11 : IGestion + Exceptions =====
        SocieteArrayList societe = new SocieteArrayList();
        DepartementHashSet gestionDep = new DepartementHashSet();

        Employe e1 = new Employe(1, "Khalil", "Sammoudi", "IT", 5);
        Employe e2 = new Employe(2, "Ali", "Ben Salah", "Finance", 3);
        Employe e3 = new Employe(3, "Mouna", "Trabelsi", "IT", 4);

        Departement d1 = new Departement(10, "Informatique");
        Departement d2 = new Departement(20, "Marketing");
        Departement d3 = new Departement(30, "Ressources Humaines");

        // ------------ GESTION DES EMPLOYÉS ------------
        try {
            System.out.println("=== Ajout des employés ===");
            societe.ajouter(e1);
            societe.ajouter(e2);
            societe.ajouter(e3);
            // Test doublon éventuel :
            // societe.ajouter(e1);

        } catch (ElementDejaExistantException ex) {
            System.out.println("Erreur (ajout employé) : " + ex.getMessage());
        }

        System.out.println("\n=== Liste des employés ===");
        societe.afficher();

        System.out.println("\n=== Tri employés par id ===");
        societe.trier().forEach(System.out::println);

        System.out.println("\n=== Tri employés par département puis grade ===");
        societe.trierParDepartementPuisGrade().forEach(System.out::println);

        // Suppression avec son propre try/catch
        try {
            System.out.println("\n=== Suppression employé e2 ===");
            societe.supprimer(e2);
        } catch (ElementInexistantException ex) {
            System.out.println("Erreur (suppression employé) : " + ex.getMessage());
        }

        System.out.println("\n=== Liste des employés après suppression ===");
        societe.afficher();

        // ------------ GESTION DES DÉPARTEMENTS ------------
        try {
            System.out.println("\n=== Ajout des départements ===");
            gestionDep.ajouter(d1);
            gestionDep.ajouter(d2);
            gestionDep.ajouter(d3);
            // Test doublon :
            // gestionDep.ajouter(d1);

        } catch (ElementDejaExistantException ex) {
            System.out.println("Erreur (ajout département) : " + ex.getMessage());
        }

        System.out.println("\n=== Liste des départements ===");
        gestionDep.afficher();

        System.out.println("\n=== Départements triés par id ===");
        gestionDep.trier().forEach(System.out::println);

        // Suppression éventuelle d’un département
        try {
            System.out.println("\n=== Suppression département d2 ===");
            gestionDep.supprimer(d2);
        } catch (ElementInexistantException ex) {
            System.out.println("Erreur (suppression département) : " + ex.getMessage());
        }

        System.out.println("\n=== Liste des départements après suppression ===");
        gestionDep.afficher();

        // ===== Rappel Prosit 10 : AffectationHashMap =====
        AffectationHashMap aff = new AffectationHashMap();
        aff.ajouterEmployeDepartement(e1, d1);
        aff.ajouterEmployeDepartement(e3, d3);

        System.out.println("\n=== Affectations initiales ===");
        aff.afficherEmployesEtDepartements();

        System.out.println("\n=== Réaffectation de e1 vers Marketing ===");
        aff.ajouterEmployeDepartement(e1, d2);
        aff.afficherEmployesEtDepartements();

        System.out.println("\n=== Map triée par id d'employé ===");
        TreeMap<Employe, Departement> mapTriee = aff.trierMap();
        for (Map.Entry<Employe, Departement> entry : mapTriee.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
