package com.viktor.javalevel2.string.homework;

import java.util.Arrays;

/**
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * <p>
 * Написать 2 метода:
 * <p>
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * <p>
 * Посчитать сумму всех чисел из строки
 * <p>
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {
    public static void main(String[] args) {
        String originalString = "Привет 8, как 1 2 твои дела? Может4, 1 сделать 3 дело?";
        int[] arrayFromString = getArrayNumbers(originalString);
        System.out.println("Sum numbers from array " + getSum(arrayFromString) +
                " -> " + Arrays.toString(arrayFromString));
    }

    private static int findLengthArray(String string) {
        int lengthArray = 0;
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (Character.isDigit(symbol)) {
                lengthArray++;
            }
        }
        return lengthArray;
    }

    private static int[] getArrayNumbers(String string) {
        int[] result = new int[findLengthArray(string)];
        int counter = 0;
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if (Character.isDigit(symbol)) {
                result[counter++] = Character.getNumericValue(symbol);
            }
        }
        return result;
    }

    private static int getSum(int[] array) {
        int sum = 0;
        for (int numb : array) {
            sum += numb;
        }
        return sum;
    }
}
