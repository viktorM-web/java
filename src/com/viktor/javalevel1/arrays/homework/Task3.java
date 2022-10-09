package com.viktor.javalevel1.arrays.homework;

/**
 * Дан одномерный массив целых чисел.
 * <p>
 * Написать функцию, которая принимает этот массив и разбивает на 3 других: с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * <p>
 * Пример:
 * <p>
 * [-4, -18]
 * <p>
 * [-4, 0, 1, 9, 0, -18, 3] -> [0, 0]
 * <p>
 * [1, 9, 3]
 */
public class Task3 {
    public static void main(String[] args) {
        int[] originalArray = {-4, 0, 1, 9, 0, -18, 3};
        int[][] resultArray = remakeArray(originalArray);
        printArray(resultArray);
    }

    private static int[][] remakeArray(int[] array) {
        int[][] result = new int[3][];
        int countZero = 0;
        int countNegative = 0;
        int countPositive = 0;
        for (int numb : array) {
            if (numb > 0) {
                countPositive++;
            } else if (numb < 0) {
                countNegative++;
            } else countZero++;
        }
        int[] zeroArray = new int[countZero];
        int[] negativeArray = new int[countNegative];
        int[] positiveArray = new int[countPositive];
        countNegative = 0;
        countZero = 0;
        countPositive = 0;
        for (int numb : array) {
            if (numb > 0) {
                positiveArray[countPositive++] = numb;
            } else if (numb < 0) {
                negativeArray[countNegative++] = numb;
            } else zeroArray[countZero++] = numb;
        }
        result[0] = negativeArray;
        result[1] = zeroArray;
        result[2] = positiveArray;
        return result;
    }

    private static void printArray(int[][] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int[] array = arrays[i];
            System.out.print("{ ");
            for (int j = 0; j < array.length; j++) {
                if (j != array.length - 1) {
                    System.out.print(array[j] + ", ");
                } else {
                    System.out.print(array[j] + " ");
                }
            }
            System.out.print("}");
            System.out.println();
        }
    }
}
