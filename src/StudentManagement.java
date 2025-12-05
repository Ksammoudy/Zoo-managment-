import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentManagement implements Management {

    @Override
    public void displayStudents(List<Student> students, Consumer<Student> con) {
        // Applique Consumer sur chaque étudiant
        students.forEach(con);
    }

    @Override
    public void displayStudentsByFilter(List<Student> students,
                                        Predicate<Student> pre,
                                        Consumer<Student> con) {
        // Filtrer selon le prédicat puis afficher avec le Consumer
        students.stream()
                .filter(pre)
                .forEach(con);
    }

    @Override
    public String returnStudentsNames(List<Student> students,
                                      Function<Student, String> fun) {
        // Transforme chaque Student en String (nom, ou autre) puis les concatène
        return students.stream()
                .map(fun)
                .collect(Collectors.joining(", "));
    }

    @Override
    public Student createStudent(Supplier<Student> sup) {
        // Crée un Student via un Supplier
        return sup.get();
    }

    @Override
    public List<Student> sortStudentsById(List<Student> students,
                                          Comparator<Student> com) {
        // Trie les étudiants selon le Comparator passé en paramètre
        return students.stream()
                .sorted(com)
                .collect(Collectors.toList());
    }

    @Override
    public Stream<Student> convertToStream(List<Student> students) {
        // Convertit la liste en Stream
        return students.stream();
    }
}
