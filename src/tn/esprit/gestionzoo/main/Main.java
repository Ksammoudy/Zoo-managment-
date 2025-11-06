package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.*;
import tn.esprit.gestionzoo.exceptions.ZooFullException;
import tn.esprit.gestionzoo.exceptions.InvalidAgeException;

public class Main {

    // Méthode utilitaire : tente l’ajout, gère les exceptions et affiche le compteur
    private static void addAndReport(Zoo zoo, Animal animal) {
        try {
            zoo.addAnimal(animal);
            System.out.println("Ajout réussi : " + animal.getName());
        } catch (ZooFullException | InvalidAgeException e) {
            System.out.println("Erreur à l’ajout de " + animal.getName() + " : " + e.getMessage());
        } finally {
            System.out.println("Nombre d’animaux après tentative : " + zoo.getNbrAnimals());
        }
    }

    public static void main(String[] args) {
        // ==================== Prosit 5 - Gestion Zoo ====================
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Zoo myZoo   = new Zoo("myZoo", "Tunis");

        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(lion);

        // ---- Ajout massif pour tester la limite ----
        for (int i = 1; i <= 5; i++) {
            String animalName = "Animal" + i;
            Animal a = new Animal("Fam" + i, animalName, i, true);
            addAndReport(myZoo, a);
        }

        myZoo.displayAnimals();

        // ---- Recherche, suppression ----
        Animal simba = new Animal("Felidae", "Simba", 5, true);
        System.out.println("Index de Simba : " + myZoo.searchAnimal(simba));

        Animal nala = new Animal("Felidae", "Nala", 4, true);
        addAndReport(myZoo, nala);
        myZoo.removeAnimal(nala);

        // ==================== Prosit 6 - Aquatic ====================
        Dolphin d2 = new Dolphin("Delphinidae", "Flipper", 8, true, "Océan", 25.5f);
        Penguin p2 = new Penguin("Spheniscidae", "Pingu", 4, false, "Antarctique", 12.3f);

        Aquatic aqDolphin = new Dolphin("Delphinidae", "Echo", 7, true, "Mer", 22.0f);
        Aquatic aqPenguin = new Penguin("Spheniscidae", "Skipper", 5, false, "Arctique", 95.0f);

        System.out.println(d2);
        System.out.println(p2);
        System.out.println(aqDolphin);
        System.out.println(aqPenguin);

        d2.swim();
        p2.swim();
        aqDolphin.swim();
        aqPenguin.swim();

        myZoo.addAquaticAnimal(d2);
        myZoo.addAquaticAnimal(p2);
        myZoo.addAquaticAnimal((Dolphin) aqDolphin);
        myZoo.addAquaticAnimal((Penguin) aqPenguin);

        myZoo.makeAllAquaticsSwim();

        float maxDepth = myZoo.maxPenguinSwimmingDepth();
        System.out.println(maxDepth < 0
                ? "Aucun pingouin trouvé dans le zoo."
                : "Profondeur maximale des pingouins: " + maxDepth + " m");

        myZoo.displayNumberOfAquaticsByType();

        // ==================== Prosit 7 - Exceptions ====================
        Animal negAge = new Animal("Testidae", "Minus", -2, true);
        addAndReport(myZoo, negAge);

        // ==================== Prosit 8 - Interfaces & Enum Food ====================
        System.out.println("\n=========== Prosit 8 : Interfaces Carnivore / Herbivore / Omnivore ===========");

        // Test du comportement carnivore et omnivore
        Dolphin dolphin = new Dolphin("Delphinidae", "Dolly", 6, true, "Océan", 28.4f);
        Penguin penguin = new Penguin("Spheniscidae", "Polo", 3, false, "Bassin", 35.5f);
        Terrestrial bear = new Terrestrial("Ursidae", "Baloo", 7, true, 4);

        System.out.println("\n--- Dolphin (Carnivore<Food>) ---");
        dolphin.eatMeat(Food.MEAT);
        dolphin.eatMeat(Food.PLANT);  // ne doit pas manger

        System.out.println("\n--- Penguin (hérite d’Aquatic) ---");
        penguin.eatMeat(Food.BOTH);   // hérite du comportement carnivore
        penguin.eatMeat(Food.PLANT);  // pas adapté

        System.out.println("\n--- Terrestrial (Omnivore<Food>) ---");
        bear.eatMeat(Food.MEAT);
        bear.eatPlant(Food.PLANT);
        bear.eatPlantAndMeet(Food.BOTH);

        System.out.println("\n=========== Fin des tests Prosit 8 ===========");
    }
}
