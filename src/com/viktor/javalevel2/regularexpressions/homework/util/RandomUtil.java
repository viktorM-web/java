package com.viktor.javalevel2.regularexpressions.homework.util;

import java.util.List;
import java.util.Random;

public final class RandomUtil {
    private static final List<String> NAMES = List.of("Иванов Иван", "Петров Петр", "Света Светикова", "Cидоров Саша");
    private static final List<String> TELEPHONES = List.of("+375 25 9998844", "33 7894523", "+375 (44) 456 89 88");
    private static final List<String> COMPLAINTS = List.of("нет света", "нет воды", "не убрали муссор");
    private static final Random RANDOM = new Random();

    private RandomUtil() {
    }

    public static String getName() {
        return NAMES.get(RANDOM.nextInt(NAMES.size()));
    }

    public static String getTelephone() {
        return TELEPHONES.get(RANDOM.nextInt(TELEPHONES.size()));
    }

    public static String getComplaints() {
        return COMPLAINTS.get(RANDOM.nextInt(COMPLAINTS.size()));
    }
}
