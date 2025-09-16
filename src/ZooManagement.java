
/*
public class ZooManagement {
    int nbrCages = 20;
    String zooName = "my zoo";

    public void displayInfo() {
        System.out.println("Zoo name: " + zooName + " | Number of cages: " + nbrCages);
    }

    public static void main(String[] args) {
        ZooManagement zoo = new ZooManagement();
        zoo.displayInfo();
    }
}
*/
import java.util.Scanner;

public class ZooManagement {
    int nbrCages;
    String zooName;

    public void displayInfo() {
        System.out.println("Zoo name: " + zooName + " | Number of cages: " + nbrCages);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ZooManagement zoo = new ZooManagement();

        // Lecture et validation du nom du zoo
        String name;
        do {
            System.out.print("Entrez le nom du zoo : ");
            name = sc.nextLine().trim();
            if (name.isEmpty()) {
                System.out.println("❌ Le nom ne peut pas être vide !");
            }
        } while (name.isEmpty());
        zoo.zooName = name;

        // Lecture et validation du nombre de cages
        int cages;
        do {
            System.out.print("Entrez le nombre de cages (entier positif) : ");
            while (!sc.hasNextInt()) { // Vérifie que l'entrée est bien un entier
                System.out.println("❌ Veuillez entrer un nombre entier !");
                sc.next(); // on ignore la mauvaise saisie
            }
            cages = sc.nextInt();
            if (cages <= 0) {
                System.out.println("❌ Le nombre de cages doit être positif !");
            }
        } while (cages <= 0);
        zoo.nbrCages = cages;

        sc.close();

        // Affichage final
        zoo.displayInfo();
    }
}
