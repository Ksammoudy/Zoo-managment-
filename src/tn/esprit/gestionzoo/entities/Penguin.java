package tn.esprit.gestionzoo.entities;

public class Penguin extends Aquatic {
    private float swimmingDepth; // en mètres

    public Penguin() { super(); }

    public Penguin(String family, String name, int age, boolean isMammal, String habitat, float swimmingDepth) {
        super(family, name, age, isMammal, habitat);
        this.swimmingDepth = swimmingDepth;
    }

    public float getSwimmingDepth() { return swimmingDepth; }
    public void setSwimmingDepth(float swimmingDepth) { this.swimmingDepth = swimmingDepth; }

    @Override
    public void swim() {
        System.out.println("🐧 Le pingouin " + getName() + " plonge jusqu'à " + swimmingDepth + " m dans " + getHabitat() + ".");
    }
}
