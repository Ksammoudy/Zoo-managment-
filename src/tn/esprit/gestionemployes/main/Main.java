package tn.esprit.gestionemployes.main;

import tn.esprit.gestionemployes.entities.Employe;
import tn.esprit.gestionemployes.services.SocieteArrayList;

public class Main {
    public static void main(String[] args) {

        SocieteArrayList societe = new SocieteArrayList();

        Employe e1 = new Employe(1, "Khalil", "Sammoudi", "IT", 5);
        Employe e2 = new Employe(2, "Ali", "Ben Salah", "Finance", 3);
        Employe e3 = new Employe(3, "Houssem", "Trabelsi", "IT", 4);

        System.out.println("=== Ajout des employés ===");
        societe.ajouterEmploye(e1);
        societe.ajouterEmploye(e2);
        societe.ajouterEmploye(e3);
        societe.displayEmploye();

        System.out.println("\n=== Recherche par nom ===");
        System.out.println("Khalil existe ? " + societe.rechercherEmploye("Khalil"));
        System.out.println("Salma existe ? " + societe.rechercherEmploye("Salma"));

        System.out.println("\n=== Tri par ID ===");
        societe.trierEmployeParId();
        societe.displayEmploye();

        System.out.println("\n=== Tri par Département puis Grade ===");
        societe.trierEmployeParNomDepartementEtGrade();
        societe.displayEmploye();

        System.out.println("\n=== Suppression ===");
        societe.supprimerEmploye(e2);
        societe.displayEmploye();
    }
}
