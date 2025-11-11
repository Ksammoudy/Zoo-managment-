package tn.esprit.gestionemployes.main;
import tn.esprit.gestionemployes.entities.*;
import tn.esprit.gestionemployes.entities.Employe;
import tn.esprit.gestionemployes.services.SocieteArrayList;

public class Main {
    public static void main(String[] args) {
        // pour le prosit 9
/*
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

 */
        // prosit 10
        DepartementHashSet gestion = new DepartementHashSet();

        Departement d1 = new Departement(1, "Informatique", 20);
        Departement d2 = new Departement(2, "Ressources Humaines", 10);
        Departement d3 = new Departement(3, "Marketing", 15);

        gestion.ajouterDepartement(d1);
        gestion.ajouterDepartement(d2);
        gestion.ajouterDepartement(d3);

        gestion.displayDepartement();

        System.out.println(" Recherche 'Informatique' : " + gestion.rechercherDepartement("Informatique"));
        System.out.println(" Recherche objet d2 : " + gestion.rechercherDepartement(d2));

        gestion.supprimerDepartement(d1);
        gestion.displayDepartement();

        System.out.println("Trié par ID : " + gestion.trierDepartementById());

    }
}
