package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public abstract class SpaceObject {
    private String name;
    private double Diameter;
    private double weight;
    private double gravityForce;
    private double temperature;

    protected SpaceObject(String name, double Diameter, double weight, double gravityForce) {
        this.name = name;
        this.Diameter = Diameter;
        this.weight = weight;
        this.gravityForce = gravityForce;
    }

    protected boolean compereSpaceObjectByWeight(SpaceObject object){
        return getDiameter()==object.getWeight();
    }

    protected abstract void getDescription();

    protected String getName() {
        return name;
    }

    protected double getDiameter() {
        return Diameter;
    }

    protected double getWeight() {
        return weight;
    }

    protected double getGravityForce() {
        return gravityForce;
    }

    protected double getTemperature() {
        return temperature;
    }

    protected void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}
