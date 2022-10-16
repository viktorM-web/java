package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class Sputnik extends SpaceObject implements Orbiting{
    private Planet planet;
    private double orbit;

    protected Sputnik(String name, double Diameter, double weight, double gravityForce, Planet planet, double orbit) {
        super(name, Diameter, weight, gravityForce);
        this.planet = planet;
        this.orbit = orbit;
    }

    @Override
    public void moveByOrbit() {
        System.out.println(getName() + "move by orbit around " + planet.getName());
    }

    @Override
    protected void getDescription() {
        System.out.println("a celestial body that rotates along a certain trajectory around another object in" +
                " outer space under the influence of gravity");
    }

    protected Planet getPlanet() {
        return planet;
    }

    protected double getOrbit() {
        return orbit;
    }

    @Override
    public String toString() {
        return "Sputnik{" +
                "planet=" + planet +
                ", radiusOrbit=" + orbit +
                '}';
    }
}
