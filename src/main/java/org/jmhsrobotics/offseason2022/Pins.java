package org.jmhsrobotics.offseason2022;

import edu.wpi.first.wpilibj.SPI;

public class Pins {
    public static class CAN {
        public static final int driveRightBack = 1;
        public static final int driveRightFront = 2;
        public static final int driveLeftBack = 3;
        public static final int driveLeftFront = 4;

        // public static final int rightBackMotorID = 1;
        // public static final int rightFrontMotorID = 2;
        // public static final int leftBackMotorID = 3;
        // public static final int leftFrontMotorID = 4;
    }

    public static class PWM {
        public static int pwmMotorExample = 0;
    }
    public static SPI.Port navxPort = SPI.Port.kMXP;
    // TODO: Look into how to select the port for the navx

}
