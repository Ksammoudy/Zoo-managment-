package tn.esprit.gestionzoo.entities;

public class Dolphin extends Aquatic {
    private float swimSpeed; // km/h

    public Dolphin() { super(); }

    public Dolphin(String family, String name, int age, boolean isMammal, String habitat, float swimSpeed) {
        super(family, name, age, isMammal, habitat);
        this.swimSpeed = swimSpeed;
    }

    public float getSwimSpeed() { return swimSpeed; }
    public void setSwimSpeed(float swimSpeed) { this.swimSpeed = swimSpeed; }

    @Override
    public void swim() {
        System.out.println("🐬 Le dauphin " + getName() + " nage à " + swimSpeed + " km/h dans " + getHabitat() + ".");
    }
}
