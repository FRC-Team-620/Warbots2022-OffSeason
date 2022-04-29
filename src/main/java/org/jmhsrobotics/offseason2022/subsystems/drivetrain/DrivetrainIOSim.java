package org.jmhsrobotics.offseason2022.subsystems.drivetrain;

import org.jmhsrobotics.offseason2022.Constants;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;

public class DrivetrainIOSim implements IDrivetrainIO {

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
    public void updateHardwareOutputs(DrivetrainHardwareOutputs outputs) {
        m_drivetrainSimulator.update(Constants.kSimUpdateTime);
        outputs.leftPositionMeters = m_drivetrainSimulator.getLeftPositionMeters();
        outputs.rightPositionMeters = m_drivetrainSimulator.getRightPositionMeters();
        outputs.yawDegrees = Rotation2d.fromDegrees(m_drivetrainSimulator.getHeading().getDegrees()).getDegrees();// limit
                                                                                                           // +-180

    }

    @Override
    public void setBrakeMode(boolean enable) { // Not Simulated Correctly
        // TODO Auto-generated method stub

    }

    @Override
    public void set(double leftpercent, double rightprecent) {
        m_drivetrainSimulator.setInputs(leftpercent * RobotController.getInputVoltage(),
                rightprecent * RobotController.getInputVoltage());

    }

}
