package com.viktor.javalevel2.multithreading.homework.Util;

import com.viktor.javalevel2.multithreading.homework.Model.CrystalType;

import java.util.Random;

public class RandomUtil {

    private static final Random RANDOM = new Random();
    private static final int MIN_NUMBER_CRYSTAL = 2;
    private static final int UPPER_BOUND = 4;

    private RandomUtil() {
    }

    public static CrystalType getRandomCrystal() {
        return CrystalType.CRYSTAL_TYPES.get(RANDOM.nextInt(CrystalType.CRYSTAL_TYPES.size()));
    }

    public static int getCountOfCrystals() {
        return MIN_NUMBER_CRYSTAL + RANDOM.nextInt(UPPER_BOUND);
    }

    public static int getNext(int bound) {
        return RANDOM.nextInt(bound);
    }
}
