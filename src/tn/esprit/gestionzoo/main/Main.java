package tn.esprit.gestionzoo.main;

import tn.esprit.gestionzoo.entities.Aquatic;   // utile pour le polymorphisme (pas d'instanciation)
import tn.esprit.gestionzoo.entities.Dolphin;
import tn.esprit.gestionzoo.entities.Penguin;
import tn.esprit.gestionzoo.entities.Animal;
import tn.esprit.gestionzoo.entities.Zoo;

public class Main {
    public static void main(String[] args) {

        // ---- Base zoo / animaux "terrestres" (Prosits précédents) ----
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Zoo myZoo   = new Zoo("myZoo", "Tunis");

        myZoo.displayZoo();
        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);

        // ---- Instruction 10 : test de capacité (27 ajouts → 25 OK, 2 refus) ----
        for (int i = 1; i <= 27; i++) {
            String animalName = "Animal" + i;
            Animal a = new Animal("Fam" + i, animalName, i, true);
            boolean okAdd = myZoo.addAnimal(a);
            System.out.println("Ajout " + animalName + " -> " + okAdd);
        }

        // ---- Instruction 11 : afficher les animaux présents ----
        myZoo.displayAnimals();

        // ---- Instruction 11 : rechercher par NOM via objet Animal ----
        Animal simba = new Animal("Felidae", "Simba", 5, true);
        System.out.println("Index de Simba avant ajout : " + myZoo.searchAnimal(simba));

        boolean okAddSimba = myZoo.addAnimal(simba);
        System.out.println("Ajout Simba -> " + okAddSimba);

        System.out.println("Index de Simba après ajout : " + myZoo.searchAnimal(simba));

        Animal simba2 = new Animal("Felidae", "Simba", 7, true);
        System.out.println("Recherche de Simba2 (même nom) -> index = " + myZoo.searchAnimal(simba2));

        // ---- Instruction 12 : unicité + capacité ----
        Animal a1 = new Animal("Felidae", "Nala", 4, true);
        Animal a2 = new Animal("Felidae", "Nala", 6, true); // doublon (même nom)

        System.out.println("Ajout Nala #1 -> " + myZoo.addAnimal(a1));
        System.out.println("Ajout Nala #2 (doublon) -> " + myZoo.addAnimal(a2));

        // Re-tests d’ajouts (le zoo est sûrement plein ici)
        for (int i = 1; i <= 5; i++) {
            Animal ai = new Animal("FamX" + i, "AX" + i, 2 + i, true);
            boolean okAddMore = myZoo.addAnimal(ai);
            System.out.println("Ajout " + ai.getName() + " (après remplissage) -> " + okAddMore);
        }

        Animal toRemove = new Animal("Felidae", "Nala", 0, true);
        System.out.println("Suppression de 'Nala' -> " + myZoo.removeAnimal(toRemove));
        System.out.println("Recherche de 'Nala' après suppression -> index = " + myZoo.searchAnimal(toRemove));
        Animal unknown = new Animal("UnknownFam", "Inconnu", 1, true);
        System.out.println("Suppression d'un animal absent -> " + myZoo.removeAnimal(unknown));
        System.out.println("Zoo plein ? " + myZoo.isZooFull());

        // ---- Instruction 16 : comparer deux zoos ----
        Zoo zoo1 = new Zoo("Zoo1", "Tunis");
        Zoo zoo2 = new Zoo("Zoo2", "Sfax");
        zoo1.addAnimal(new Animal("Felidae", "Simba", 5, true));
        zoo1.addAnimal(new Animal("Equidae", "Marty", 4, true));
        zoo2.addAnimal(new Animal("Accipitridae", "Aquila", 3, false));
        Zoo bigger = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Le zoo avec le plus d'animaux est : " + bigger.getName());

        // ================= Prosit 6 : Aquatiques (Instructions 25 → 30) =================

        // ⚠️ Aquatic est ABSTRAITE → on n'instancie pas Aquatic directement !
        // On utilise des sous-classes concrètes : Dolphin, Penguin.
        Dolphin d2 = new Dolphin("Delphinidae", "Flipper", 8, true, "Océan", 25.5f);
        Penguin p2 = new Penguin("Spheniscidae", "Pingu", 4, false, "Antarctique", 12.3f);

        // Polymorphisme via type de référence Aquatic (ok, mais instanciés en sous-classes)
        Aquatic aqDolphin = new Dolphin("Delphinidae", "Echo", 7, true, "Mer", 22.0f);
        Aquatic aqPenguin = new Penguin("Spheniscidae", "Skipper", 5, false, "Arctique", 95.0f);

        // Affichage (toString)
        System.out.println(d2);
        System.out.println(p2);
        System.out.println(aqDolphin);
        System.out.println(aqPenguin);

        // Test direct du polymorphisme (swim)
        d2.swim();
        p2.swim();
        aqDolphin.swim();
        aqPenguin.swim();

        // Ajout au tableau aquatique du Zoo (Instr. 26)
        myZoo.addAquaticAnimal(d2);
        myZoo.addAquaticAnimal(p2);
        myZoo.addAquaticAnimal((Dolphin) aqDolphin);
        myZoo.addAquaticAnimal((Penguin) aqPenguin);

        // Instr. 27 : faire nager tout le monde
        myZoo.makeAllAquaticsSwim();
        System.out.println("\nRemarque: chaque swim() appelle la version de la sous-classe → polymorphisme.");

        // Instr. 29 : profondeur max des pingouins
        float maxDepth = myZoo.maxPenguinSwimmingDepth();
        System.out.println(maxDepth < 0
                ? "Aucun pingouin trouvé dans le zoo."
                : "Profondeur maximale des pingouins: " + maxDepth + " m");

        // Instr. 30 : stats par type
        myZoo.displayNumberOfAquaticsByType();
    }
}
