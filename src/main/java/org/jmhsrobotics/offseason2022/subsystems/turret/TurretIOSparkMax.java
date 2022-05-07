package org.jmhsrobotics.offseason2022.subsystems.turret;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMax.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.jmhsrobotics.offseason2022.Pins;

import edu.wpi.first.wpilibj.DigitalInput;

public class TurretIOSparkMax implements TurretIO {
    private CANSparkMax turretMotor;
    private DigitalInput calibrationSwitch;
    private SparkMaxPIDController pidController;

    private final double countsToDegreesFactor = (1.0 / (5.23 * 5.23)) * (20.0 / 156.0) * 360.0;

    public TurretIOSparkMax() {
        turretMotor = new CANSparkMax(Pins.CAN.kTurretMotor, MotorType.kBrushless);
        calibrationSwitch = new DigitalInput(Pins.DIO.kTurretCalibrationSwitch);

        turretMotor.getEncoder().setPositionConversionFactor(countsToDegreesFactor); // * 0.914
        IdleMode mode = IdleMode.kBrake; // brakes
        turretMotor.setIdleMode(mode);
        turretMotor.setSmartCurrentLimit(18);

        pidController = turretMotor.getPIDController();
    }

    @Override
    public void updateHardwareOutputs(TurretHardwareOutputs outputs) {
        outputs.rotationDegrees = turretMotor.getEncoder().getPosition();
        outputs.isCalibrationSwitch = calibrationSwitch.get();

        outputs.velocityRPM = turretMotor.getEncoder().getVelocity(); // TODO: Update to degrees per second
        outputs.appliedDutyCycle = turretMotor.getAppliedOutput();
        outputs.currentAmps = new double[] { turretMotor.getOutputCurrent() };
        outputs.tempCelcius = new double[] { turretMotor.getMotorTemperature() };
    }

    @Override
    public void set(double speed) {
        turretMotor.set(speed);

    }

    @Override
    public void setSetpoint(double degrees) {
        pidController.setReference(degrees, ControlType.kPosition); // TODO verifiy

    }

    @Override
    public void setPID(double kP, double kI, double kD) {
        pidController.setP(kP);
        pidController.setI(kI);
        pidController.setD(kD);
    }

    @Override
    public void setMaxIntegrator(double maxI) {
        pidController.setIMaxAccum(maxI, 0); // TODO look up slot meaning May not work
    }

    @Override
    public void setBrakeMode(boolean enable) {
        IdleMode mode = enable ? IdleMode.kBrake : IdleMode.kCoast;
        turretMotor.setIdleMode(mode);
    }

    @Override
    public void setEncoderPositionDegrees(double degrees) {
        turretMotor.getEncoder().setPosition(degrees);
    }

}
