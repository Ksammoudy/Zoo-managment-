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


        Animal lion = new Animal("Felidae", "Simba", 5, true);
        Zoo myZoo   = new Zoo("myZoo", "Tunis", 25);
        myZoo.displayZoo();

        System.out.println(myZoo);
        System.out.println(myZoo.toString());
        System.out.println(lion);


    }
}
