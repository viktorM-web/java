package com.viktor.javalevel2.multithreading.homework.Thread;

import com.viktor.javalevel2.multithreading.homework.Model.CrystalType;
import com.viktor.javalevel2.multithreading.homework.Model.Mage;
import com.viktor.javalevel2.multithreading.homework.Model.Planet;
import com.viktor.javalevel2.multithreading.homework.Util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class Rocket extends Thread {

    private final Planet planet;
    private final Mage mage;

    public Rocket(Planet planet, Mage mage) {
        this.planet = planet;
        this.mage = mage;
    }

    @Override
    public void run() {
        while (!Mage.winnerExist()) {
            List<CrystalType> crystals = gatherCristalFromPlanet();
            mage.addCrystals(crystals);
            synchronized (Night.class) {
                try {
                    Night.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private List<CrystalType> gatherCristalFromPlanet() {
        int countCrystal = RandomUtil.getCountOfCrystals();
        List<CrystalType> gatheredCrystalsFromPlanet = new ArrayList<>(countCrystal);
        synchronized (planet) {
            if (planet.size() <= countCrystal && planet.isHaveMinNumberCrystal()) {
                gatheredCrystalsFromPlanet.addAll(planet.removeAll());
            } else if (planet.isHaveMinNumberCrystal()) {
                for (int j = 0; j < countCrystal; j++) {
                    CrystalType removedCristal = planet.remove(RandomUtil.getNext(planet.size()));
                    gatheredCrystalsFromPlanet.add(removedCristal);
                }
            }
            System.out.printf("%s на ракету погрузили следующие кристалы: %s\n", mage.getRace(), gatheredCrystalsFromPlanet);
        }
        return gatheredCrystalsFromPlanet;
    }

    public Mage getMage() {
        return mage;
    }
}
