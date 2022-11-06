package com.viktor.javalevel2.multithreading.homework.Model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Planet {

    private static final int MIN_NUMBER_CRYSTAL = 2;
    private final List<CrystalType> crystals = new LinkedList<>();

    public CrystalType remove(int index) {
        return crystals.remove(index);
    }

    public void add(CrystalType crystal) {
        crystals.add(crystal);
    }

    public int size() {
        return crystals.size();
    }

    public List<CrystalType> removeAll() {
        List<CrystalType> copyCrystalsList = new ArrayList<>(crystals);
        crystals.clear();
        return copyCrystalsList;
    }

    public boolean isHaveMinNumberCrystal() {
        return size()>=MIN_NUMBER_CRYSTAL;
    }
}
