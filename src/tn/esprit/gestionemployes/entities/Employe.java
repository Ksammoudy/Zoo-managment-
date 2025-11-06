package tn.esprit.gestionemployes.entities;

import java.util.Objects;

public class Employe implements Comparable<Employe> {
    private int id;
    private String nom;
    private String prenom;
    private String nomDepartement;
    private int grade;

    // Constructeur sans paramètre
    public Employe() {}

    // Constructeur avec paramètres
    public Employe(int id, String nom, String prenom, String nomDepartement, int grade) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.nomDepartement = nomDepartement;
        this.grade = grade;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    public String getNomDepartement() { return nomDepartement; }
    public void setNomDepartement(String nomDepartement) { this.nomDepartement = nomDepartement; }

    public int getGrade() { return grade; }
    public void setGrade(int grade) { this.grade = grade; }

    // Redéfinition equals : égalité selon id et nom
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employe)) return false;
        Employe e = (Employe) obj;
        return this.id == e.id && Objects.equals(this.nom, e.nom);
    }

    // toString
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", departement='" + nomDepartement + '\'' +
                ", grade=" + grade +
                '}';
    }

    // Comparable → tri par ID
    @Override
    public int compareTo(Employe o) {
        return Integer.compare(this.id, o.id);
    }
}
