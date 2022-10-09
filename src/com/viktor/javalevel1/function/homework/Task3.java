package com.viktor.javalevel1.function.homework;

/**
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * <p>
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */

public class Task3 {

    public static void main(String[] args) {
        compare(getSquare(12, 15), getSquare(15, 14));

    }

    private static double getSquare(int fistSide, int secondSide) {
        return fistSide * secondSide / 2.0;
    }

    private static void compare(double firstSquare, double secondSquare) {
        if (firstSquare > secondSquare) {
            System.out.println("First triangle bigger the second");
        } else if (firstSquare < secondSquare) {
            System.out.println("First triangle less the second");
        } else System.out.println("Triangles equals");
    }
}
