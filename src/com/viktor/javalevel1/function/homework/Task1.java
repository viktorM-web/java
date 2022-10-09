package com.viktor.javalevel1.function.homework;

import java.util.Random;

/**
 * Задание 1
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */

public class Task1 {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 60;
    private static final int MINUTES = RANDOM.nextInt(BOUND);

    public static void main(String[] args) {
        findQuarter(MINUTES);
    }

    private static void findQuarter(int minutes) {
        if (minutes > 0 && minutes < 15) {
            System.out.println("Value is " + minutes + " It's first quarter");
        } else if (minutes > 15 && minutes < 30) {
            System.out.println("Value is " + minutes + " It's second quarter");
        } else if (minutes > 30 && minutes < 45) {
            System.out.println("Value is " + minutes + " It's third quarter");
        } else if (minutes > 45 && minutes < 60) {
            System.out.println("Value is " + minutes + " It's fourth quarter");
        } else {
            switch (minutes) {
                case 0 -> System.out.println("Value is " + minutes + " between fourth and first quarters");
                case 15 -> System.out.println("Value is " + minutes + " between first and second quarters");
                case 30 -> System.out.println("Value is " + minutes + " between second and third quarters");
                case 45 -> System.out.println("Value is " + minutes + " between third and fourth quarters");
                default -> System.out.println("Not correct value");
            }
        }
    }
}
