package com.viktor.javalevel2.multithreading.homework;

import com.viktor.javalevel2.multithreading.homework.Model.Mage;
import com.viktor.javalevel2.multithreading.homework.Model.Planet;
import com.viktor.javalevel2.multithreading.homework.Thread.Growing;
import com.viktor.javalevel2.multithreading.homework.Thread.Night;
import com.viktor.javalevel2.multithreading.homework.Thread.Rocket;
import com.viktor.javalevel2.multithreading.homework.Util.ThreadUtil;

/**
 * Существует две постоянно соревнующиеся расы: маги огня и маги воздуха.
 * Их задача - как можно быстрее набрать 500 красных и 500 белых кристаллов.
 * <p>
 * Кристаллы растут на другой планете с рандомной скоростью от 2 до 5 рандомных кристаллов в сутки (может быть 1 красный и 2 белых, а может и вовсе все 4 кристалла красного цвета).
 * <p>
 * Маги огня и маги воздуха отправляют раз в сутки по ракете за добычей кристаллов.
 * Каждая ракета может погрузить на борт от 2 до 5 рандомных кристаллов.
 * Если кристаллов нет - ракета улетает пустой.
 * <p>
 * Написать программу, которая симулирует процесс заполнения кристаллов у магов огня и воздуха.
 * Для симуляции принять, что и кристаллы создаются, и ракеты прилетают в одно и то же время - полночь.
 * <p>
 * Соревнование заканчивается, когда какая-то раса соберет необходимые кристаллы.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Planet planetCrystals = new Planet();
        Night night = new Night(planetCrystals);
        Growing growing = new Growing(planetCrystals);
        Rocket rocketMageFire = new Rocket(planetCrystals, new Mage("Маги огня"));
        Rocket rocketMageAir = new Rocket(planetCrystals, new Mage("Маги воздуха"));

        ThreadUtil.startThreads(night, rocketMageFire, rocketMageAir, growing);
        ThreadUtil.joinThreads(night, growing, rocketMageFire, rocketMageAir);

        showWinner(rocketMageFire, rocketMageAir);
    }

    private static void showWinner(Rocket... rockets) {
        for (Rocket rocket : rockets) {
            if (rocket.getMage().isWinner()) {
                System.out.println(rocket.getMage() + " Победили!!!!");
            }
        }
    }
}
