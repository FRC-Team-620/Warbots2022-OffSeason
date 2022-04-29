package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.jmhsrobotics.offseason2022.subsystems.drivetrain.IDrivetrainIO.DrivetrainHardwareOutputs;
import org.jmhsrobotics.offseason2022.util.DifferentalDriveMath;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {

    private final IDrivetrainIO io;
    private final DrivetrainHardwareOutputs outputs;
    private DifferentialDriveOdometry odom;

    public Drivetrain(IDrivetrainIO io) {
        this.io = io;
        this.outputs = new DrivetrainHardwareOutputs();
        odom = new DifferentialDriveOdometry(new Rotation2d());
    }

    public Pose2d getPose() {
        return odom.getPoseMeters();
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("DriveTrain", outputs);

        odom.update(Rotation2d.fromDegrees(outputs.yawDegrees), outputs.leftPositionMeters,
                outputs.rightPositionMeters);
    }

    public void curvatureDrive(double forwardSpeed, double rotationSpeed) {
        WheelSpeeds speeds = DifferentalDriveMath.fromCurvature(forwardSpeed, rotationSpeed);
        io.set(speeds.left, speeds.right);
    }

    public void arcadeDrive(double forwardSpeed, double rotationSpeed) {
        WheelSpeeds speeds = DifferentalDriveMath.fromArcade(forwardSpeed, rotationSpeed);
        io.set(speeds.left, speeds.right);
    }

}
