package tn.esprit.gestionemployes.entities;

import java.util.Objects;

public class Departement {
    private int id;
    private String nom;
    private int nbEmployes;

    // Constructeur sans paramètre
    public Departement() {}

    // Constructeur avec paramètres
    public Departement(int id, String nom, int nbEmployes) {
        this.id = id;
        this.nom = nom;
        this.nbEmployes = nbEmployes;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    public void setNbEmployes(int nbEmployes) {
        this.nbEmployes = nbEmployes;
    }

    // Redéfinition de equals (id et nom)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Departement)) return false;
        Departement d = (Departement) obj;
        return this.id == d.id && Objects.equals(this.nom, d.nom);
    }

    // Redéfinition de hashCode (cohérent avec equals)
    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    // Redéfinition de toString
    @Override
    public String toString() {
        return "Departement { " +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbEmployes=" + nbEmployes +
                " }";
    }
}
