package tn.esprit.gestionzoo.entities;

public class Animal {
    // Attributs privés (encapsulation)
    private String family;
    private String name;
    private int age;
    private boolean isMammal;

    // Constructeurs
    public Animal() {}

    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age; // ✅ plus de vérification ici
        this.isMammal = isMammal;
    }

    // Getters et Setters
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        // ❌ on ne lève plus IllegalArgumentException ici
        this.age = age;
    }

    public boolean isMammal() {
        return isMammal;
    }

    public void setMammal(boolean mammal) {
        isMammal = mammal;
    }

    // Méthodes d’affichage
    public void displayAnimal() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Animal { family='" + family + "', name='" + name +
                "', age=" + age + ", isMammal=" + isMammal + " }";
    }
}
