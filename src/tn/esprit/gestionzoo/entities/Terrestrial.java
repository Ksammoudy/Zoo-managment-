package tn.esprit.gestionzoo.entities;

public class Terrestrial extends Animal implements Omnivore<Food> {
    private int nbrLegs;

    public Terrestrial() {
        super();
    }

    public Terrestrial(String family, String name, int age, boolean isMammal, int nbrLegs) {
        super(family, name, age, isMammal);
        this.nbrLegs = nbrLegs;
    }

    public int getNbrLegs() {
        return nbrLegs;
    }

    public void setNbrLegs(int nbrLegs) {
        this.nbrLegs = nbrLegs;
    }

    // Prosit 8 — Omnivore<Food>
    @Override
    public void eatMeat(Food meat) {
        if (meat == Food.MEAT || meat == Food.BOTH) {
            System.out.println(getName() + " (Terrestrial) mange de la viande.");
        } else {
            System.out.println(getName() + " (Terrestrial) ne mange pas uniquement des plantes.");
        }
    }

    @Override
    public void eatPlant(Food plant) {
        if (plant == Food.PLANT || plant == Food.BOTH) {
            System.out.println(getName() + " (Terrestrial) mange des plantes.");
        } else {
            System.out.println(getName() + " (Terrestrial) ne mange pas uniquement de la viande.");
        }
    }

    @Override
    public void eatPlantAndMeet(Food food) {
        if (food == Food.BOTH) {
            System.out.println(getName() + " (Terrestrial) mange viande ET plantes (omnivore).");
        } else if (food == Food.MEAT) {
            System.out.println(getName() + " (Terrestrial) mange surtout de la viande (peut aussi manger des plantes).");
        } else { // PLANT
            System.out.println(getName() + " (Terrestrial) mange surtout des plantes (peut aussi manger de la viande).");
        }
    }

    @Override
    public String toString() {
        return "Terrestrial {" +
                "family='" + getFamily() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", isMammal=" + isMammal() +
                ", nbrLegs=" + nbrLegs +
                '}';
    }
}
