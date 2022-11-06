package com.viktor.javalevel2.multithreading.homework.Thread;

import com.viktor.javalevel2.multithreading.homework.Model.Mage;
import com.viktor.javalevel2.multithreading.homework.Model.Planet;

public class Night extends Thread {
    private static final int NIGHT_INTERVAL = 100;

    private final Planet planet;

    public Night(Planet planet) {
        this.planet = planet;
    }

    @Override
    public void run() {
        synchronized (Night.class) {
            int counterDays = 1;
            while (!Mage.winnerExist()) {
                try {
                    System.out.printf("----------------\nСутки %s начались\n", (counterDays++));
                    Night.class.notifyAll();
                    Night.class.wait(NIGHT_INTERVAL);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Night.class.notifyAll();
        }
    }
}
