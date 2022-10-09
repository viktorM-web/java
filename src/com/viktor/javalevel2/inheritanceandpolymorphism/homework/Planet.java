package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class Planet extends SpaceObject implements Orbiting{
    private Star star;
    private double Orbit;

    protected Planet(String name, double Diameter, double weight, double gravityForce, Star star, double Orbit) {
        super(name, Diameter, weight, gravityForce);
        this.star = star;
        this.star.heat(this);
        this.Orbit = Orbit;
    }

    @Override
    public void moveByOrbit() {
        System.out.println(getName() + " move by orbit around " + star.getName());
    }

    @Override
    protected void getDescription() {
        System.out.println("a celestial body that revolves around the Sun and is not a satellite of one" +
                " of the planets, having a spherical shape and with its gravity capable of “clearing” " +
                "the surroundings from other, smaller celestial bodies.");
    }

    @Override
    public String toString() {
        return "Planet{" +
                "star=" + star +
                ", radiusOrbit=" + Orbit +
                '}';
    }

    protected Star getStar() {
        return star;
    }

    protected void setStar(Star star) {
        this.star = star;
    }

    protected double getOrbit() {
        return Orbit;
    }

    protected void setOrbit(int orbit) {
        this.Orbit = orbit;
    }
}
