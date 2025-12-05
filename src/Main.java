import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManagement sm = new StudentManagement();

        List<Student> students = new ArrayList<>();
        students.add(new Student(3, "Ali", 22));
        students.add(new Student(1, "Sami", 20));
        students.add(new Student(2, "Sara", 21));

        // Afficher tous les étudiants
        sm.displayStudents(students, System.out::println);

        // Afficher uniquement les étudiants dont l’âge > 20
        System.out.println("\nÉtudiants avec âge > 20 :");
        sm.displayStudentsByFilter(
                students,
                s -> s.getAge() > 20,
                System.out::println
        );

        // Retourner une chaîne contenant les noms
        String names = sm.returnStudentsNames(
                students,
                Student::getName
        );
        System.out.println("\nNoms des étudiants : " + names);

        // Trier par id
        List<Student> sorted = sm.sortStudentsById(
                students,
                Comparator.comparingInt(Student::getId)
        );
        System.out.println("\nÉtudiants triés par id :");
        sorted.forEach(System.out::println);
    }
}
