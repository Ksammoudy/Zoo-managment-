package tn.esprit.gestionemployes.services;

import tn.esprit.gestionemployes.entities.Employe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SocieteArrayList implements IGestion<Employe> {

    private List<Employe> listEmployes = new ArrayList<>();

    @Override
    public void ajouterEmploye(Employe e) {
        listEmployes.add(e);
    }

    @Override
    public boolean rechercherEmploye(String nom) {
        for (Employe e : listEmployes) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean rechercherEmploye(Employe e) {
        return listEmployes.contains(e);
    }

    @Override
    public void supprimerEmploye(Employe e) {
        listEmployes.remove(e);
    }

    @Override
    public void displayEmploye() {
        for (Employe e : listEmployes) {
            System.out.println(e);
        }
    }

    @Override
    public void trierEmployeParId() {
        Collections.sort(listEmployes);
    }

    @Override
    public void trierEmployeParNomDepartementEtGrade() {
        Collections.sort(listEmployes, new Comparator<Employe>() {
            @Override
            public int compare(Employe e1, Employe e2) {
                int cmpDep = e1.getNomDepartement().compareToIgnoreCase(e2.getNomDepartement());
                if (cmpDep != 0) return cmpDep;
                return Integer.compare(e1.getGrade(), e2.getGrade());
            }
        });
    }
}
