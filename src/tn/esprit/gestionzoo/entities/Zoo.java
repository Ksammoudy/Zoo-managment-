package tn.esprit.gestionzoo.entities;

public class Zoo {
    // ✅ Capacité fixe : un zoo contient max 25 animaux
    public static final int NBR_CAGES = 25;

    // ✅ Encapsulation (attributs privés)
    private Animal[] animals; // taille NBR_CAGES
    private String name;
    private String city;

    // ✅ Compteur d’animaux
    private int animalCount = 0;

    // ✅ Constructeur par défaut
    public Zoo() {
        this.animals = new Animal[NBR_CAGES];
    }

    // ✅ Constructeur paramétré (validation du nom non vide)
    public Zoo(String name, String city) {
        setName(name);         // valide : non null / non vide
        setCity(city);
        this.animals = new Animal[NBR_CAGES];
    }

    // ===================== Getters / Setters =====================

    public String getName() {
        return name;
    }

    // Instruction 18 : le nom d’un Zoo ne doit pas être vide
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Le nom du zoo ne doit pas être vide.");
        }
        this.name = name.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = (city == null) ? "" : city.trim();
    }

    public int getAnimalCount() {
        return animalCount;
    }

    public Animal[] getAnimals() {
        return animals;
    }

    // ===================== Méthodes métier =====================

    // ✅ Instruction 12 : refuser doublon + refuser dépassement de capacité
    public boolean addAnimal(Animal animal) {
        if (animal == null) return false;

        // 1) refuser si zoo plein
        if (isZooFull()) {
            return false;
        }

        // 2) refuser doublon (unicité par NOM) — utiliser getters de Animal
        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null
                    && animals[i].getName() != null
                    && animal.getName() != null
                    && animals[i].getName().equalsIgnoreCase(animal.getName())) {
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
        if (animal == null || animal.getName() == null) return -1;

        for (int i = 0; i < animals.length; i++) {
            if (animals[i] != null
                    && animal.getName().equalsIgnoreCase(animals[i].getName())) {
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
