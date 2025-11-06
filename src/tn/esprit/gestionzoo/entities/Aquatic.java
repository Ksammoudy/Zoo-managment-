package tn.esprit.gestionzoo.entities;

import java.util.Objects;

public abstract class Aquatic extends Animal implements Carnivore<Food> {
    protected String habitat; // mer, océan, bassin...

    public Aquatic() {
        super();
    }

    public Aquatic(String family, String name, int age, boolean isMammal, String habitat) {
        super(family, name, age, isMammal);
        this.habitat = habitat;
    }

    public String getHabitat() { return habitat; }
    public void setHabitat(String habitat) { this.habitat = habitat; }

    // Instruction 28: obliger la redéfinition dans les sous-classes
    public abstract void swim();

    // Prosit 8 — Carnivore<Food>
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " (Aquatic) mange de la viande.");
        } else {
            System.out.println(getName() + " (Aquatic) ne mange pas de plantes.");
        }
    }

    // Instruction 31: même nom + même âge + même habitat
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aquatic)) return false;
        Aquatic aquatic = (Aquatic) o;
        return getAge() == aquatic.getAge()
                && Objects.equals(getName(), aquatic.getName())
                && Objects.equals(habitat, aquatic.habitat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), habitat);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                " { family='" + getFamily() + "', name='" + getName() +
                "', age=" + getAge() + ", isMammal=" + isMammal() +
                ", habitat='" + habitat + "' }";
    }
}
