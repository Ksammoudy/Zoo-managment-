public class Zoo {
    // ✅ Capacité fixe : un zoo contient max 25 animaux
    public static final int NBR_CAGES = 25;

    Animal[] animals; // taille NBR_CAGES
    String name;
    String city;

    // ✅ Compteur d’animaux (Instruction 10)
    private int animalCount = 0;

    // ✅ Constructeur par défaut
    public Zoo() {
        this.animals = new Animal[NBR_CAGES];
    }

    // ✅ Constructeur paramétré (plus de nbrCages en paramètre)
    public Zoo(String name, String city) {
        this.name = name;
        this.city = city;
        this.animals = new Animal[NBR_CAGES];
    }

    // ✅ Instruction 12 : refuser doublon + refuser dépassement de capacité
    public boolean addAnimal(Animal animal) {
        if (animal == null) return false;

        // 1) refuser si zoo plein
        if (animalCount >= NBR_CAGES) {
            return false;
        }

        // 2) refuser doublon (unicité par NOM)
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animals[i].name != null && animal.name != null
                    && animals[i].name.equalsIgnoreCase(animal.name)) {
                return false; // déjà présent
            }
        }

        // 3) ajouter case par case (première case libre)
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] == null) {
                animals[i] = animal;
                animalCount++;
                return true;
            }
        }
        return false; // sécurité
    }

    // ✅ Instruction 8 : méthode d’affichage
    public void displayZoo() {
        System.out.println("Zoo { name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + " }");
    }

    // ✅ Pour afficher directement l’objet avec println(zoo)
    @Override
    public String toString() {
        return "Zoo { name='" + name + "', city='" + city + "', nbrCages=" + NBR_CAGES + " }";
    }

    // ✅ Instruction 11 : afficher tous les animaux
    public void displayAnimals() {
        System.out.println("=== Liste des animaux dans le zoo " + name + " ===");
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null) {
                System.out.println("[" + i + "] " + animals[i]);
            }
        }
        System.out.println("Total animaux = " + animalCount + "/" + NBR_CAGES);
    }

    // ✅ Instruction 11 : rechercher par NOM — retourne l’index ou -1
    public int searchAnimal(Animal animal) {
        if (animal == null || animal.name == null) return -1;

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null && animal.name.equalsIgnoreCase(animals[i].name)) {
                return i; // trouvé → on retourne l'index
            }
        }
        return -1;
    }

    // ✅ Instruction 13 : supprimer un animal et compacter
    public boolean removeAnimal(Animal animal) {
        if (animal == null) return false;

        int idx = searchAnimal(animal);
        if (idx == -1) return false; // pas trouvé

        // Décaler à gauche pour éviter les "trous"
        for (int i = idx; i < animals.length - 1; i++) {
            animals[i] = animals[i + 1];
        }
        animals[animals.length - 1] = null;

        animalCount--;
        return true;
    }

    public boolean isZooFull() {
        return animalCount >= NBR_CAGES;
    }
    public static Zoo comparerZoo(Zoo z1, Zoo z2) {
        if (z1 == null) return z2;
        if (z2 == null) return z1;

        if (z1.animalCount > z2.animalCount) {
            return z1;
        } else if (z2.animalCount > z1.animalCount) {
            return z2;
        } else {
            // égalité → on retourne arbitrairement z1
            return z1;
        }
    }
}
