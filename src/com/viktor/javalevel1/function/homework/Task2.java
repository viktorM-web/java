package com.viktor.javalevel1.function.homework;

import java.util.Random;

/**
 * Даны 3 переменные:
 * <p>
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * <p>
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 * <p>
 * Например:
 * Параметры: operand1 = 24.4, operand2 = 10.1, operation = ‘+’
 * Результат: 34.5 (24.4 + 10.1)
 */

public class Task2 {
    private static final Random RANDOM = new Random();
    private static final int BOUND_FO_NUMBER = 100;
    private static final int BOUND_FO_SYMBOL = 5;
    private static final double VALUE1 = RANDOM.nextDouble() + RANDOM.nextInt(BOUND_FO_NUMBER);
    private static final double VALUE2 = RANDOM.nextDouble() + RANDOM.nextInt(BOUND_FO_NUMBER);

    public static void main(String[] args) {
        char symbol = getSymbol();
        calculate(VALUE1, VALUE2, symbol);
    }

    private static void calculate(double value1, double value2, char action) {
        switch (action) {
            case '+' -> System.out.println(value1 + value2 + " (" + value1 + " + " + value2 + ")");
            case '-' -> System.out.println(value1 - value2 + " (" + value1 + " - " + value2 + ")");
            case '*' -> System.out.println(value1 * value2 + " (" + value1 + " * " + value2 + ")");
            case '/' -> System.out.println(value1 / value2 + " (" + value1 + " / " + value2 + ")");
            case '%' -> System.out.println(value1 % value2 + " (" + value1 + " % " + value2 + ")");
            default -> System.out.println("Not correct symbol");
        }
    }

    private static char getSymbol() {
        return switch (RANDOM.nextInt(BOUND_FO_SYMBOL)) {
            case 0 -> '+';
            case 1 -> '-';
            case 2 -> '*';
            case 3 -> '/';
            case 4 -> '%';
            default -> ' ';
        };
    }
}
