package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.jmhsrobotics.core.subsystems.IDrivetrain;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.DrivetrainIO.DrivetrainIOInputs;
import org.jmhsrobotics.offseason2022.util.WheelSpeeds;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase implements IDrivetrain {

    private final DrivetrainIO io;
    private final DrivetrainIOInputs inputs;
    private DifferentialDriveOdometry odom;
    Field2d f;
    public Drivetrain(DrivetrainIO io) {
        this.io = io;
        this.inputs = new DrivetrainIOInputs();
        odom = new DifferentialDriveOdometry(new Rotation2d());
        f = new Field2d();
        SmartDashboard.putData(f);

        // Drivetrain
    }
    @Override
    public void periodic() {
        io.updateInputs(inputs);
        Logger.getInstance().processInputs("DriveTrain", inputs);
        odom.update(Rotation2d.fromDegrees(inputs.yaw), inputs.leftPosition, inputs.rightPosition);
        f.setRobotPose(odom.getPoseMeters());
        // // TODO Auto-generated method stub
        // super.periodic();
    }

    @Override
    public void controlVolts(double forward, double rotate) {
        // t.from
        var speeds = WheelSpeeds.fromArcade(forward,rotate);
        io.setVoltage(speeds.left, speeds.right);
        // TODO Auto-generated method stub

    }

    @Override
    public void controlVelocity(double forward, double rotation) {
        // io.setVoltage(leftVolts, rightVolts);

    }

}
