package com.viktor.javalevel2.multithreading.homework.Thread;

import com.viktor.javalevel2.multithreading.homework.Model.CrystalType;
import com.viktor.javalevel2.multithreading.homework.Model.Mage;
import com.viktor.javalevel2.multithreading.homework.Model.Planet;
import com.viktor.javalevel2.multithreading.homework.Util.RandomUtil;

public class Growing extends Thread {

    private final Planet planet;

    public Growing(Planet planet) {
        this.planet = planet;
    }

    @Override
    public void run() {
        while (!Mage.winnerExist()) {
            int countCrystal = RandomUtil.getCountOfCrystals();
            synchronized (planet) {
                System.out.println("За сутки выросло " + countCrystal + " кристалов:");
                for (int i = 0; i < countCrystal; i++) {
                    CrystalType crystal = RandomUtil.getRandomCrystal();
                    planet.add(crystal);
                    System.out.println(crystal);
                }
            }
            synchronized (Night.class) {
                try {
                    Night.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
