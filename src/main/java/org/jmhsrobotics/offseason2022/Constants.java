// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.jmhsrobotics.offseason2022;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean
 * constants. This class should not be used for any other purpose. All constants
 * should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public static final double gearRatio = 0.12;
    public static final double kTrackwidthMeters = 0.64;// 0.5207
    public static final double wheelDiameterInInches = 6; // TODO: Be more clear on if this is A drive wheel or shooter
                                                          // wheel
    

    public static final double kSimGearRatio = Constants.gearRatio;
    public static final double kSimTrackwidthMeters = Constants.kTrackwidthMeters;
    public static final double kSimDrivekVLinear = 1.98;
    public static final double ksimDrivekALinear = 0.2;
    public static final double ksimDrivekVAngular = 1.5;
    public static final double kSimDrivekAAngular = 0.3;
    public static final double kSimShooterInertia = 0.5*Units.lbsToKilograms(1.5)*Math.pow(Units.inchesToMeters(4/2),2); //1/2*M*R^2 
    public static final double kSimTurntableInertia = 0.5*Units.lbsToKilograms(0.1)*Math.pow(Units.inchesToMeters(3),2); //TODO: switch to ring formula vs disk
    public static final double kSimTurntableGearRatio = 500.0;//5*(156.0/16.0);
    public static final double kSimUpdateTime = 0.02;
    public static final double kSimRobotWeight = Units.lbsToKilograms(120);
    public static final double kSimClimberGearRatio = 1;
    public static final double kSimClimberDrumSize = 0.2;
    public static final double ksimClimberMaxHeight = Units.feetToMeters(6);
}
