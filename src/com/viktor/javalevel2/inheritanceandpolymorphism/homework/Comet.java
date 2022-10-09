package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class Comet extends Planet{
    private int tailLength;

    protected Comet(String name, double Diameter, double weight, double gravityForce, Star star, double Orbit,
                 int tailLength) {
        super(name, Diameter, weight, gravityForce, star, Orbit);
        this.tailLength=tailLength;
    }

    @Override
    protected void getDescription() {
        System.out.println("a small celestial body that revolves around the sun in a very elongated " +
                "orbit in the form of a conic section. When approaching the Sun, a comet forms a coma " +
                "and sometimes a tail of gas and dust.");
    }

    @Override
    public String toString() {
        return "Comet{" +
                "tailLength=" + tailLength +
                '}';
    }
}
