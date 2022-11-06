package com.viktor.javalevel2.multithreading.homework.Model;

import java.util.Arrays;
import java.util.List;

public enum CrystalType {
    RED,
    WHITE;

    public static final List<CrystalType> CRYSTAL_TYPES = Arrays.asList(values());
}
