package org.jmhsrobotics.offseason2022;

import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.SPI;

public class Pins {
    public static class CAN {
        public static final int kDriveRightBack = 1;
        public static final int kDriveRightFront = 2;
        public static final int kDriveLeftBack = 3;
        public static final int kDriveLeftFront = 4;

        public static final int kInnerIntakeMotor = 10;
        public static final int kIntakeMotor = 11;

        public static final int kLeftClimberMotor = 7;
        public static final int kRightClimberMotor = 8;

        public static final int kTurretMotor = 9;

    }

    public static class PWM {
        public static int pwmMotorExample = 0;
    }

    public static class PCM {
        public static final PneumaticsModuleType kPneumaticsModuleType = PneumaticsModuleType.CTREPCM;
        public static final int kIntakeArmA = 3;
        public static final int kIntakeArmB = 4;

    }
    public static class DIO {
        public static final int kIntakeSwitch = 7;

        public static final int kClimberSensor = 8; //TODO: Rename

        public static final int kTurretCalibrationSwitch = 9;
    }
    public static SPI.Port kNavxPort = SPI.Port.kMXP;
    // TODO: Look into how to select the port for the navx

}
