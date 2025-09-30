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
        setAge(age); // utilise le setter pour valider
        this.isMammal = isMammal;
    }

    // Getters et Setters avec validation
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
        if (age < 0) {
            throw new IllegalArgumentException("L'âge d'un animal ne peut pas être négatif.");
        }
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
