package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.jmhsrobotics.offseason2022.Pins;

public class DrivetrainIOSparkMAX implements IDrivetrainIO {
    private final CANSparkMax leftLeader, leftFollower, rightLeader, rightFollower;
    private AHRS navx;
    private final int kCurrentLimitAmps = 60;
    private final double kConversionFactor = 1;

    public DrivetrainIOSparkMAX() {
        leftFollower = new CANSparkMax(Pins.CAN.driveLeftBack, MotorType.kBrushless);
        leftLeader = new CANSparkMax(Pins.CAN.driveLeftFront, MotorType.kBrushless);
        rightFollower = new CANSparkMax(Pins.CAN.driveRightBack, MotorType.kBrushless);
        rightLeader = new CANSparkMax(Pins.CAN.driveRightFront, MotorType.kBrushless);
        navx = new AHRS(Pins.navxPort);

        rightFollower.follow(rightLeader);
        leftFollower.follow(leftLeader);

        rightLeader.setInverted(true);
        leftLeader.setInverted(true);

        leftFollower.setSmartCurrentLimit(kCurrentLimitAmps);
        leftLeader.setSmartCurrentLimit(kCurrentLimitAmps);

        rightFollower.setSmartCurrentLimit(kCurrentLimitAmps);
        rightLeader.setSmartCurrentLimit(kCurrentLimitAmps);

        leftLeader.getEncoder().setPositionConversionFactor(kConversionFactor);//TODO look into position vs vel conversion
        rightLeader.getEncoder().setPositionConversionFactor(kConversionFactor);
    }

    @Override
    public void updateHardwareOutputs(DrivetrainHardwareOutputs inputs) {
        inputs.leftPosition = leftLeader.getEncoder().getPosition();
        inputs.rightPosition = rightLeader.getEncoder().getPosition();
        inputs.yaw = navx.getYaw(); //TODO: Look into getting fused yaw
        // TODO Auto-generated method stub

    }

    // @Override
    // public void setVoltage(double leftVolts, double rightVolts) {
    // // TODO Auto-generated method stub

    // }

    // @Override
    // public void setVelocity(double leftVelocityRadPerSec, double
    // rightVelocityRadPerSec, double leftFFVolts,
    // double rightFFVolts) {
    // // TODO Auto-generated method stub

    // }

    @Override
    public void setBrakeMode(boolean enable) {
        IdleMode mode = enable ? IdleMode.kBrake : IdleMode.kCoast;
        leftLeader.setIdleMode(mode);
        leftFollower.setIdleMode(mode);
        rightLeader.setIdleMode(mode);
        rightFollower.setIdleMode(mode);
        // TODO Auto-generated method stub

    }

    @Override
    public void set(double leftpercent, double rightprecent) {
        leftLeader.set(leftpercent);
        rightLeader.set(rightprecent);
    }

}
