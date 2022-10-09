package com.viktor.javalevel1.arrays.homework;

import java.util.Arrays;

/**
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел, где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * <p>
 * Далее определить среднее арифметическое всех элементов целочисленного массива и вывести на консоль только те элементы,
 * которые больше этого среднего арифметического.
 */
public class Task2 {
    public static void main(String[] args) {
        char[] originalArraySymbols = {'a', '6', 'y', 'P', 'T', 'q', '9', '+'};
        int[] resultArrayNumbers = changeType(originalArraySymbols);
        System.out.println(Arrays.toString(originalArraySymbols));
        System.out.println(Arrays.toString(resultArrayNumbers));
        printElementsBiggerAverage(resultArrayNumbers);
    }

    private static void printElementsBiggerAverage(int[] arrayNumbers) {
        double average = getArithmeticalMean(arrayNumbers);
        for (int numb : arrayNumbers) {
            if (numb > average) {
                System.out.print(numb + " ");
            }
        }
        System.out.print(" are bigger then arithmetical mean which equals " + average);
    }

    private static double getArithmeticalMean(int[] arrayNumbers) {
        int sum = 0;
        for (int numb : arrayNumbers) {
            sum += numb;
        }
        return (double) sum / arrayNumbers.length;
    }

    private static int[] changeType(char[] arraySymbols) {
        int[] result = new int[arraySymbols.length];
        for (int i = 0; i < arraySymbols.length; i++) {
            result[i] = arraySymbols[i];
        }
        return result;
    }
}
