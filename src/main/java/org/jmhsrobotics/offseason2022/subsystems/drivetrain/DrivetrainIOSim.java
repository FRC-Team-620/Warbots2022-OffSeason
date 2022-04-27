package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.jmhsrobotics.offseason2022.Constants;

import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;

public class DrivetrainIOSim implements DrivetrainIO {

    private DifferentialDrivetrainSim m_drivetrainSimulator;

    public DrivetrainIOSim() {
        LinearSystem<N2, N2, N2> m_drivetrainSystem = LinearSystemId.identifyDrivetrainSystem(
                Constants.kSimDrivekVLinear,
                Constants.ksimDrivekALinear, Constants.ksimDrivekVAngular,
                Constants.kSimDrivekAAngular);
        m_drivetrainSimulator = new DifferentialDrivetrainSim(
                m_drivetrainSystem, DCMotor.getNEO(2), Constants.gearRatio, Constants.kTrackwidthMeters,
                Units.inchesToMeters(Constants.wheelDiameterInInches / 2), null);
    }

    @Override
    public void updateInputs(DrivetrainIOInputs inputs) {
        m_drivetrainSimulator.update(Constants.kSimUpdateTime);
        inputs.leftPosition = m_drivetrainSimulator.getLeftPositionMeters();
        inputs.rightPosition = m_drivetrainSimulator.getRightPositionMeters();
        inputs.yaw = m_drivetrainSimulator.getHeading().getDegrees();

    }

    @Override
    public void setVoltage(double leftVolts, double rightVolts) {
        m_drivetrainSimulator.setInputs(leftVolts, rightVolts);

    }

    @Override
    public void setVelocity(double leftVelocityRadPerSec, double rightVelocityRadPerSec, double leftFFVolts,
            double rightFFVolts) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setBrakeMode(boolean enable) { // Not Simulated Correctly
        // TODO Auto-generated method stub

    }

    @Override
    public void configurePID(double kp, double ki, double kd) {
        // TODO Auto-generated method stub

    }

}
