package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class PlanetsRing extends Sputnik{
    private double width;

    protected PlanetsRing(String name, double Diameter, double weight, double gravityForce, Planet planet, double radiusOrbit) {
        super(name, Diameter, weight, gravityForce, planet, radiusOrbit);
        this.width = Diameter - (radiusOrbit * 2.0);
    }

    @Override
    protected void getDescription() {
        System.out.println("a system of flat concentric formations of ice and dust, located in the equatorial plane" +
                " of the planet " + getPlanet().getName());
    }

    @Override
    public String toString() {
        return "PlanetsRing{" +
                "width=" + width +
                '}';
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }
}
