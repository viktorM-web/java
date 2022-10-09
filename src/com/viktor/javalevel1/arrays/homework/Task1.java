package com.viktor.javalevel1.arrays.homework;

import java.util.Arrays;

/**
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 * <p>
 * Не забывать, что всю логику приложения нужно выносить в отдельные функции. main - только для тестирования написанного функционала.
 */
public class Task1 {
    public static void main(String[] args) {
        int[] originalArray = {3, 5, -6, 3, 2, -9, 0, -123};
        int[] result = createArray(originalArray);
        System.out.println(Arrays.toString(result));
    }

    private static int[] createArray(int[] array) {
        int lengthResultArray = 0;
        int counter = 0;
        for (int numb : array) {
            if (numb >= 0) {
                lengthResultArray++;
            }
        }
        int[] resultArray = new int[lengthResultArray];
        for (int numb : array) {
            if (numb >= 0) {
                resultArray[counter++] = numb * lengthResultArray;
            }
        }
        return resultArray;
    }
}
