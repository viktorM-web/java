package com.viktor.javalevel1.cycles.homework;

/**
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * <p>
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {
    public static void main(String[] args) {
        int numb = 1002300;
        System.out.println(numb + " -> " + reversNumber(numb));
    }

    public static int reversNumber(int number) {
        int current = number;
        int result = 0;
        while (current != 0) {
            result = result * 10 + current % 10;
            current /= 10;
        }
        return result;
    }
}
