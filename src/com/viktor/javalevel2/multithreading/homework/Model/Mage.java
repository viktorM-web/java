package com.viktor.javalevel2.multithreading.homework.Model;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import static com.viktor.javalevel2.multithreading.homework.Model.CrystalType.RED;
import static com.viktor.javalevel2.multithreading.homework.Model.CrystalType.WHITE;

public class Mage {

    private static boolean winnerAmongMage = false;
    private boolean winner = false;
    private final String race;
    private final Map<CrystalType, Integer> crystals = new EnumMap<>(CrystalType.class);

    public Mage(String race) {
        this.race = race;
    }

    public static boolean winnerExist() {
        return winnerAmongMage;
    }

    public void addCrystals(List<CrystalType> list) {
        list.forEach(detail -> crystals.merge(detail, 1, Integer::sum));
        checkForVictory();
    }

    private void checkForVictory() {
        int requiredNumberOfCrystalsToWin = 500;
        if (crystals.get(RED) != null && crystals.get(RED) >= requiredNumberOfCrystalsToWin
                && crystals.get(WHITE) != null && crystals.get(WHITE) >= requiredNumberOfCrystalsToWin) {
            winnerAmongMage = true;
            winner = true;
        }
    }

    @Override
    public String toString() {
        return "Mage{" +
                "race='" + race + '\'' +
                '}';
    }

    public String getRace() {
        return race;
    }

    public boolean isWinner() {
        return winner;
    }

    public Map<CrystalType, Integer> getCrystals() {
        return crystals;
    }
}
