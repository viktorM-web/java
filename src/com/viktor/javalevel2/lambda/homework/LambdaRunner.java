package com.viktor.javalevel2.lambda.homework;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * Дан список студентов с полями:
 * - Имя
 * - Фамилия
 * - Номер курса в университете
 * - Список оценок за учебу
 * <p>
 * Преобразовать этот список студентов в ассоциативный массив, где ключом является номер курса, а значением:
 * <p>
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * <p>
 * Список студентов данного курса, но только с полями Имя и Фамилия.
 * Список должен быть отсортированы по этим двум полям
 * <p>
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 * <p>
 * Подумать, как ассоциативный массив можно было представить в коде в виде отсортированного - TreeMap
 */
public class LambdaRunner {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Ivan", "Ivanov", 1, List.of(4, 4, 4, 5, 3, 4, 5, 3, 4)),
                new Student("Petr", "Petrov", 3, List.of(5, 5, 5, 4, 4, 5, 4)),
                new Student("Sergei", "Sergeinko", 2, List.of(3, 3, 3, 3, 3, 3, 3, 3, 3)),
                new Student("Pavel", "Pavlov", 1, List.of(5, 4, 5, 3, 3, 5, 4, 5)),
                new Student("Artem", "Pavlov", 1, List.of(3, 3, 4)),
                new Student("Sveta", "Svetikova", 3, List.of(5, 4, 5, 3, 3)),
                new Student("Maria", "Mutko", 2, List.of(4, 5, 5, 4, 3, 3, 5)),
                new Student("Andrei", "Irko", 2, List.of(4, 5, 3, 4, 5))
        );
        Map<Integer, Double> averageMarksByCourse = students.stream()
                .filter(student -> student.marks().size() > 3)
                .collect(Collectors.groupingBy(Student::courseNumber, Collectors.averagingDouble(
                        student -> student.marks().stream().mapToInt(Integer::intValue).average().orElse(0))));
        System.out.println(averageMarksByCourse);
        System.out.println();
        Map<Integer, List<StudentName>> listStudentsByCourse = students.stream()
                .sorted(Comparator.comparing(Student::name).thenComparing(Student::lastName))
                .collect(Collectors.groupingBy(Student::courseNumber,
                        Collectors.mapping((student -> new StudentName(student.name(), student.lastName())),
                                Collectors.toList())));
        System.out.println(listStudentsByCourse);
        System.out.println();
        Map<Integer, InfoByCourse> statisticByCourse = students.stream()
                .sorted(Comparator.comparing(Student::name).thenComparing(Student::lastName))
                .collect(Collectors.groupingBy(Student::courseNumber, collectingAndThen(toList(), list -> {
                    double averageMarks = list.stream().collect(
                            Collectors.averagingDouble(student -> student.marks()
                                    .stream().mapToInt(Integer::intValue).average().orElse(0)));
                    List<StudentName> studentNames = list.stream()
                            .map((student -> new StudentName(student.name(), student.lastName())))
                            .collect(Collectors.toList());
                    return new InfoByCourse(studentNames, averageMarks);
                })));
        System.out.println(statisticByCourse);
    }
}

record Student(String name, String lastName, int courseNumber, List<Integer> marks) {
}

record StudentName(String name, String lastName) {
}

record InfoByCourse(List<StudentName> student, double mark) {
}