package tn.esprit.gestionzoo.entities;

import tn.esprit.gestionzoo.exceptions.InvalidAgeException;
import tn.esprit.gestionzoo.exceptions.ZooFullException;

public class Zoo {
    // ====== Partie "zoo d'animaux" (Prosit 7) ======
    // Capacité réduite à 3 comme demandé
    public static final int NBR_CAGES = 3;

    private final Animal[] animals = new Animal[NBR_CAGES];
    private String name;
    private String city;
    private int animalCount = 0;

    // Constructeurs
    public Zoo() {}

    public Zoo(String name, String city) {
        setName(name);
        setCity(city);
    }

    // Getters/Setters
    public String getName() { return name; }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide.");
        this.name = name.trim();
    }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = (city == null) ? "" : city.trim(); }

    public int getAnimalCount() { return animalCount; }
    // Alias pour compatibilité avec certains Main : getNbrAnimals()
    public int getNbrAnimals() { return animalCount; }

    public Animal[] getAnimals() { return animals; }

    // ====== Métier (animaux) ======
    // Prosit 7 : addAnimal -> void + exceptions
    public void addAnimal(Animal animal) throws ZooFullException, InvalidAgeException {
        if (animal == null) {
            // Rien à faire si null (aucune exception demandée pour ce cas)
            return;
        }
        // Instruction 34 : interdire âge négatif
        if (animal.getAge() < 0) {
            throw new InvalidAgeException(
                    "Âge négatif interdit pour l’animal: " + animal.getName()
            );
        }
        // Instruction 32/33 : si plein -> lever ZooFullException
        if (isZooFull()) {
            throw new ZooFullException("Zoo plein: capacité maximale (" + NBR_CAGES + ") atteinte.");
        }
        // Anti-doublon par NOM (même nom => on n’ajoute pas, pas d’exception demandée)
        for (Animal a : animals) {
            if (a != null && a.getName() != null
                    && a.getName().equalsIgnoreCase(animal.getName())) {
                // Doublon : on ignore simplement
                return;
            }
        }
        // Ajouter à la première case libre
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                animalCount++;
                return;
            }
        }
        // Sécurité (normalement jamais atteint car isZooFull() couvre le cas)
        throw new ZooFullException("Aucune case libre trouvée malgré le contrôle de capacité.");
    }

    public void displayZoo() {
        System.out.println("Zoo { name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + " }");
    }

    @Override
    public String toString() {
        return "Zoo { name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + " }";
    }

    public void displayAnimals() {
        System.out.println("=== Liste des animaux dans le zoo " + name + " ===");
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) System.out.println("[" + i + "] " + animals[i]);
        }
        System.out.println("Total animaux = " + animalCount + "/" + NBR_CAGES);
    }

    public int searchAnimal(Animal animal) {
        if (animal == null || animal.getName() == null) return -1;
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null
                    && animal.getName().equalsIgnoreCase(animals[i].getName())) {
                return i;
            }
        }
        return -1;
    }

    public boolean removeAnimal(Animal animal) {
        if (animal == null) return false;
        int idx = searchAnimal(animal);
        if (idx == -1) return false;

        for (int i = idx; i < animals.length - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animals.length - 1] = null;
        animalCount--;
        return true;
    }

    public boolean isZooFull() { return animalCount >= NBR_CAGES; }

    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;
        if (z1.animalCount > z2.animalCount) return z1;
        if (z2.animalCount > z1.animalCount) return z2;
        return z1; // égalité
    }

    // ====== Partie "aquatiques" (Prosit 6 — Instructions 25 → 30) ======

    // Instruction 25 : tableau des aquatiques (10 max)
    private final Aquatic[] aquaticAnimals = new Aquatic[10];
    private int aquaticCount = 0;

    // Instruction 26 : ajout d'un aquatique (avec anti-doublon par equals)
    public void addAquaticAnimal(Aquatic aquatic) {
        if (aquatic == null) {
            System.out.println("❌ Impossible d'ajouter: référence nulle.");
            return;
        }
        if (aquaticCount >= aquaticAnimals.length) {
            System.out.println("❌ Tableau des aquatiques plein (max " + aquaticAnimals.length + ").");
            return;
        }
        for (int i = 0; i < aquaticCount; i++) {
            if (aquatic.equals(aquaticAnimals[i])) {
                System.out.println("⚠️ Animal aquatique déjà présent: " + aquatic.getName());
                return;
            }
        }
        aquaticAnimals[aquaticCount++] = aquatic;
        System.out.println("✅ Ajouté: " + aquatic.getClass().getSimpleName() + " (" + aquatic.getName() + ")");
    }

    // Instruction 27 : appeler swim() pour tous
    public void makeAllAquaticsSwim() {
        System.out.println("\n--- Tous les aquatiques nagent ---");
        for (int i = 0; i < aquaticCount; i++) {
            aquaticAnimals[i].swim(); // polymorphisme
        }
    }

    // Instruction 29 : profondeur max des pingouins
    public float maxPenguinSwimmingDepth() {
        float max = -1f;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Penguin) {
                float d = ((Penguin) aquaticAnimals[i]).getSwimmingDepth();
                if (d > max) max = d;
            }
        }
        return max; // -1 si aucun pingouin
    }

    // Instruction 30 : compter par type
    public void displayNumberOfAquaticsByType() {
        int dolphins = 0, penguins = 0;
        for (int i = 0; i < aquaticCount; i++) {
            if (aquaticAnimals[i] instanceof Dolphin) dolphins++;
            else if (aquaticAnimals[i] instanceof Penguin) penguins++;
        }
        System.out.println("\n--- Statistiques aquatiques ---");
        System.out.println("Nombre de dauphins : " + dolphins);
        System.out.println("Nombre de pingouins : " + penguins);
    }
}
