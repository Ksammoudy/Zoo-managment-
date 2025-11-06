package tn.esprit.gestionzoo.entities;

// L'intitulé demande "eatPlantAndMeet" (avec 2 e) — on respecte à la lettre.
public interface Omnivore<T> extends Carnivore<T>, Herbivore<T> {
    void eatPlantAndMeet(T food);
}
