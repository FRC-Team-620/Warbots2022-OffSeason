package org.jmhsrobotics.offseason2022.util;

/** Represents a left and right percentage. */
public class WheelSpeeds {
    public double left;
    public double right;

    public WheelSpeeds(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public static WheelSpeeds fromArcade(double baseSpeed, double turnSpeed) {
        return new WheelSpeeds(baseSpeed + turnSpeed, baseSpeed - turnSpeed);
    }

    public static WheelSpeeds fromCurvature(double baseSpeed,
            double turnSpeed) {
        turnSpeed = Math.abs(baseSpeed) * turnSpeed;
        return new WheelSpeeds(baseSpeed + turnSpeed, baseSpeed - turnSpeed);
    }
}
