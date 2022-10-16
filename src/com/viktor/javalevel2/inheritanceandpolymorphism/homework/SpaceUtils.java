package com.viktor.javalevel2.inheritanceandpolymorphism.homework;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static double getGravityForce(SpaceObject firstObject, SpaceObject secondObject) {
        return firstObject.getGravityForce() > secondObject.getGravityForce() ?
                firstObject.getGravityForce() - secondObject.getGravityForce() :
                secondObject.getGravityForce() - firstObject.getGravityForce();
    }

    public static boolean isStar(SpaceObject object) {
        return object instanceof Star;
    }
}
