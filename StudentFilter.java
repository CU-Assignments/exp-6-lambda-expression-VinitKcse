import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 78),
            new Student("Bob", 65),
            new Student("Charlie", 90),
            new Student("David", 80),
            new Student("Eve", 72)
        );

        // Filtering students with marks above 75%
        List<String> topStudents = students.stream()
            .filter(s -> s.marks > 75)  // Filter students scoring above 75%
            .sorted((s1, s2) -> Double.compare(s2.marks, s1.marks))  // Sort in descending order of marks
            .map(s -> s.name)  // Extract names
            .collect(Collectors.toList());

        // Display the names of the top students
        System.out.println("Students scoring above 75% (sorted by marks):");
        topStudents.forEach(System.out::println);
    }
}
