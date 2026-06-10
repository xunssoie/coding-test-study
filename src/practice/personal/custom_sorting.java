package practice.personal;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class custom_sorting {

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Alice", 85));
        students.add(new Student("Bob", 72));
        students.add(new Student("Charlie", 91));

        Comparator<Student> byNameWithAnonymous = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.name.compareTo(o2.name);
            }
        };

        Comparator<Student> byNameWithLambda = (o1, o2) -> o1.name.compareTo(o2.name);

        Comparator<Student> byNameWithLib = Comparator.comparing(Student::getName);

        Comparator<Student> byScoreWithLib = Comparator.comparing(Student::getScore);

        students.sort(byNameWithLambda);

        for (Student student : students) {
            System.out.println(student.name + ": " + student.score);
        }

        students.sort(byNameWithLib);

        for (Student student : students) {
            System.out.println(student.name + ": " + student.score);
        }

        students.sort(byScoreWithLib);

        for (Student student : students) {
            System.out.println(student.name + ": " + student.score);
        }

        Comparator<Student> byScoreThenName = Comparator.comparing(Student::getScore)
                .thenComparing(Student::getName);

        students.sort(byScoreThenName);

        for (Student student : students) {
            System.out.println(student.name + ": " + student.score);
        }
    }

    static class Student implements Comparable<Student>{
        String name;
        int score;

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(@NotNull Student o) {
            return Integer.compare(score, o.score);
        }

        public String getName() {
            return name;
        }

        public int getScore() {
            return score;
        }
    }
}
