package org.jmhsrobotics.offseason2022.util;

import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;

public class DifferentalDriveMath {

    public static WheelSpeeds fromArcade(double baseSpeed, double turnSpeed) { 
        return new WheelSpeeds(baseSpeed + turnSpeed, baseSpeed - turnSpeed);
    }

    public static WheelSpeeds fromCurvature(double baseSpeed,
            double turnSpeed) {
        turnSpeed = Math.abs(baseSpeed) * turnSpeed;
        return new WheelSpeeds(baseSpeed + turnSpeed, baseSpeed - turnSpeed);
    }
}
