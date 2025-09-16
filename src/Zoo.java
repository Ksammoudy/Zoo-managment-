public class Zoo {
    // ✅ NB: le zoo contient max 25 animaux
    public static final int MAX_ANIMALS = 25;

    Animal[] animals; // taille MAX_ANIMALS
    String name;
    String city;
    int nbrCages;

    // ✅ Constructeur par défaut
    public Zoo() {
        this.animals = new Animal[MAX_ANIMALS];
    }

    // ✅ Constructeur paramétré (Instruction 6 & 7)
    public Zoo(String name, String city, int nbrCages) {
        this.name = name;
        this.city = city;
        this.nbrCages = nbrCages;
        this.animals = new Animal[MAX_ANIMALS];
    }

    // (facultatif) méthode utilitaire d’ajout
    public boolean addAnimal(Animal a, int index) {
        if (index < 0 || index >= MAX_ANIMALS) return false;
        animals[index] = a;
        return true;
    }

    // ✅ Instruction 8 : méthode d’affichage
    public void displayZoo() {
        System.out.println("Zoo { name='" + name + "', city='" + city + "', nbrCages=" + nbrCages + " }");
    }

    // ✅ Pour afficher directement l’objet avec println(zoo)
    @Override
    public String toString() {
        return "Zoo { name='" + name + "', city='" + city + "', nbrCages=" + nbrCages + " }";
    }
}
