package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public class Star extends SpaceObject implements Heating {
    private int classLuminosity;

    protected Star(String name, double Diameter, double weight, double gravityForce, int classLuminosity) {
        super(name, Diameter, weight, gravityForce);
        this.classLuminosity = classLuminosity;
        int temperature = switch (classLuminosity){
            case 1 -> 30_000;
            case 2 -> 15_000;
            case 3 -> 10_000;
            default -> 5000;
        };
        this.setTemperature(temperature);
    }

    @Override
    public void heat(SpaceObject object) {
            if(object instanceof Planet){
                Planet planet = (Planet) object;
                planet.setTemperature(getTemperature()/planet.getOrbit());
            }
            if(object instanceof Sputnik){
                Sputnik sputnik = (Sputnik) object;
                sputnik.setTemperature(getTemperature()/sputnik.getPlanet().getOrbit()-sputnik.getOrbit());
            }
    }

    @Override
    protected void getDescription() {
        System.out.println("Star source of light and heat");
    }

    @Override
    public String toString() {
        return "Star{" +
                "classLuminosity=" + classLuminosity +
                '}';
    }
}
