import java.util.Scanner;
/*
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Création de l'objet ZooManagement
        ZooManagement zoo = new ZooManagement();

        // 🔹 Lecture et validation du nom du zoo
        String name;
        do {
            System.out.print("Entrez le nom du zoo : ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("❌ Le nom ne peut pas être vide !");
            }
        } while (name.isEmpty());
        zoo.zooName = name;

        // 🔹 Lecture et validation du nombre de cages
        int cages;
        do {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            while (!sc.hasNextInt()) { // Vérifie que l'entrée est un entier
                System.out.println("❌ Veuillez entrer un nombre entier !");
                sc.next(); // ignore la mauvaise saisie
            }
            cages = sc.nextInt();
            if (cages <= 0) {
                System.out.println("❌ Le nombre de cages doit être positif !");
            }
        } while (cages <= 0);
        zoo.nbrCages = cages;

        sc.close();

        // 🔹 Affichage final
        zoo.displayInfo();
    }
}

*/
public class Main {
    public static void main(String[] args) {

        // ---- Ton ancien code (inchangé) ----
        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Zoo myZoo   = new Zoo("myZoo", "Tunis");
        myZoo.displayZoo();

        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);

        // ---- Instruction 10 : test de capacité (on tente d'ajouter 27 animaux) ----
        for (int i = 1; i <= 27; i++) {
            String animalName = "Animal" + i;
            Animal a = new Animal("Fam" + i, animalName, i, true);
            boolean okAdd = myZoo.addAnimal(a);
            System.out.println("Ajout " + animalName + " -> " + okAdd);
        }
        // Attendu : Animal1..Animal25 -> true ; Animal26.. -> false (zoo plein)

        // ---- Instruction 11 : afficher les animaux présents ----
        myZoo.displayAnimals();

        // ---- Instruction 11 : tester la recherche par nom (via un objet Animal) ----
        Animal simba = new Animal("Felidae", "Simba", 5, true);

        // Avant ajout de Simba (selon l’état actuel du zoo, probablement -1 si pas présent)
        System.out.println("Index de Simba avant ajout : " + myZoo.searchAnimal(simba));

        // Tenter d'ajouter Simba (si le zoo est plein, ce sera false)
        boolean okAddSimba = myZoo.addAnimal(simba);
        System.out.println("Ajout Simba -> " + okAddSimba);

        // Après tentative d’ajout
        System.out.println("Index de Simba après ajout : " + myZoo.searchAnimal(simba));

        // Créer un autre animal identique à Simba et le chercher
        Animal simba2 = new Animal("Felidae", "Simba", 7, true);
        System.out.println("Recherche de Simba2 (identique) -> index = " + myZoo.searchAnimal(simba2));

        // ---- Instruction 12 : unicité + capacité ----
        // Tester l’unicité (même nom) : Nala ne doit être ajoutée qu’une seule fois
        Animal a1 = new Animal("Felidae", "Nala", 4, true);
        Animal a2 = new Animal("Felidae", "Nala", 6, true); // même nom -> doit être refusé

        System.out.println("Ajout Nala #1 -> " + myZoo.addAnimal(a1)); // true si place disponible
        System.out.println("Ajout Nala #2 (doublon) -> " + myZoo.addAnimal(a2)); // false attendu

        // (Optionnel) Re-tenter des ajouts pour montrer le refus post-capacité
        for (int i = 1; i <= 5; i++) {
            Animal ai = new Animal("FamX" + i, "AX" + i, 2 + i, true);
            boolean okAddMore = myZoo.addAnimal(ai);
            System.out.println("Ajout " + ai.name + " (après remplissage) -> " + okAddMore); // false attendu si plein
        }
        Animal toRemove = new Animal("Felidae", "Nala", 0, true); // même nom que celui ajouté
        System.out.println("Suppression de 'Nala' -> " + myZoo.removeAnimal(toRemove)); // true si présente

// Vérifier que 'Nala' n'est plus trouvée
        System.out.println("Recherche de 'Nala' après suppression -> index = " + myZoo.searchAnimal(toRemove)); // -1 attendu

// Essayer de supprimer un animal absent
        Animal unknown = new Animal("UnknownFam", "Inconnu", 1, true);
        System.out.println("Suppression d'un animal absent -> " + myZoo.removeAnimal(unknown));
        System.out.println("Zoo plein ? " + myZoo.isZooFull());
// ---- Instruction 16 : comparer deux zoos ----
        Zoo zoo1 = new Zoo("Zoo1", "Tunis");
        Zoo zoo2 = new Zoo("Zoo2", "Sfax");

// Ajouter quelques animaux
        zoo1.addAnimal(new Animal("Felidae", "Simba", 5, true));
        zoo1.addAnimal(new Animal("Equidae", "Marty", 4, true));

        zoo2.addAnimal(new Animal("Accipitridae", "Aquila", 3, false));

// Comparer
        Zoo bigger = Zoo.comparerZoo(zoo1, zoo2);
        System.out.println("Le zoo avec le plus d'animaux est : " + bigger.name);

    }

}
