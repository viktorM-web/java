package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class SpaceRunner {
    public static void main(String[] args) {
        Star sun = new Star("Sun", 1392.7, 19_890_000, 274, 1);
        Planet mercury = new Planet("Mercury", 4.879, 3.285, 3.7, sun, 57.91);
        Planet venus = new Planet("Venus", 12.1, 48.67, 8.87, sun, 107.5);
        Planet earth = new Planet("Earth",12.742, 59.72, 9.807, sun,  149.6);
        Planet mars = new Planet("Mars", 6.78, 6.39, 3.721, sun, 227.99);
        Planet saturn = new Planet("Saturn", 116.46, 5683.0, 10.44, sun, 1513.33);
        Sputnik lune = new Sputnik("Luna", 3.475, 0.73, 1.62, earth,0.405);
        Sputnik fobos = new Sputnik("Fobos", 0.0226, 0.00000001,0.0057, mars, 0.06);
        Sputnik demos = new Sputnik("Demos",0.00012, 0.00000001,0.00003, mars, 0.002);
        PlanetsRing saturnRing = new PlanetsRing("Rings A", 250, 0.00000000001, 0, saturn,
                0.002 );
        Comet cometHalleys = new Comet("Halley", 0.0000000000011,0.0000000000022,0, sun,
                87.661, 1000000000);
        System.out.println(SpaceUtils.isStar(sun));
        System.out.println(SpaceUtils.isStar(lune));
        System.out.println(SpaceUtils.getGravityForce(mars,earth));
        saturnRing.moveByOrbit();
        System.out.println(sun.compereSpaceObjectByWeight(mars));
    }
}
