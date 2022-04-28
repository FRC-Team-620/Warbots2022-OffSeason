package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.jmhsrobotics.core.subsystems.IDrivetrain;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.IDrivetrainIO.DrivetrainHardwareOutputs;
import org.jmhsrobotics.offseason2022.util.WheelSpeeds;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase implements IDrivetrain {

    private final IDrivetrainIO io;
    private final DrivetrainHardwareOutputs outputs;
    private DifferentialDriveOdometry odom;

    public DrivetrainSubsystem(IDrivetrainIO io) {
        this.io = io;
        this.outputs = new DrivetrainHardwareOutputs();
        odom = new DifferentialDriveOdometry(new Rotation2d());

        // Drivetrain
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("DriveTrain", outputs);

        
        odom.update(Rotation2d.fromDegrees(outputs.yaw), outputs.leftPosition, outputs.rightPosition);
    }

    public void curve(double forward, double rotation) {
        WheelSpeeds speeds = WheelSpeeds.fromCurvature(forward, rotation);
        io.set(speeds.left, speeds.right);
    }

    @Override
    public void controlVolts(double forward, double rotate) {
        // t.from
        // var speeds = WheelSpeeds.fromArcade(forward, rotate);
        // if (forward < 2) {
        // io.setBrakeMode(true);
        // } else {
        // io.setBrakeMode(false);
        // }
        // // io.setVoltage(speeds.left, speeds.right);
        // // io.
        // // TODO Auto-generated method stub

    }

    @Override
    public void controlVelocity(double forward, double rotation) {
        // io.setVoltage(leftVolts, rightVolts);

    }

}
