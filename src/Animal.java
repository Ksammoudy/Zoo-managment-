public class Animal {
    String family;
    String name;
    int age;
    boolean isMammal;

    // ✅ Constructeur par défaut (nécessaire si on veut pouvoir faire new Animal() ailleurs)
    public Animal() {}

    // ✅ Constructeur paramétré (Instruction 6 & 7)
    public Animal(String family, String name, int age, boolean isMammal) {
        this.family = family;
        this.name = name;
        this.age = age;
        this.isMammal = isMammal;
    }

    // ✅ Méthode d'affichage (Instruction 9 – version méthode)
    public void displayAnimal() {
        System.out.println("Animal { family='" + family + "', name='" + name +
                "', age=" + age + ", isMammal=" + isMammal + " }");
    }

    // ✅ toString() pour affichage direct avec System.out.println(animal)
    @Override
    public String toString() {
        return "Animal { family='" + family + "', name='" + name +
                "', age=" + age + ", isMammal=" + isMammal + " }";
    }
}
