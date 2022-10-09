package com.viktor.javalevel2.string.homework;

/**
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом. Также удалить пробелы.
 * Результат привести к верхнему регистру.
 * <p>
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {
    public static void main(String[] args) {
        String originalString = "abc Cpddd DCio OsfWw";
        System.out.println(format(originalString));
    }

    private static String format(String originalString) {
        StringBuilder result = new StringBuilder(originalString.toUpperCase()
                .replace(" ", ""));
        for (int i = 0; i < result.length() - 1; ) {
            int nextNumb = i + 1;
            char current = result.charAt(i);
            char next = result.charAt(nextNumb);
            if (current == next) {
                result.deleteCharAt(nextNumb);
                continue;
            }
            i++;
        }
        return result.toString();
    }
}
