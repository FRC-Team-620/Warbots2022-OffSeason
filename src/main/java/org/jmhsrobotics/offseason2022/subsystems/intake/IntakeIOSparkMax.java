package org.jmhsrobotics.offseason2022.subsystems.intake;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import org.jmhsrobotics.offseason2022.Pins;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

public class IntakeIOSparkMax implements IntakeIO {
    private CANSparkMax innerIntakeMotor;
    private Solenoid intakeArmsVirtualSolenoidA;
    private Solenoid intakeArmsVirtualSolenoidB;
    private CANSparkMax intakeArmsMotor;
    private DigitalInput intakeSwitch;

    public IntakeIOSparkMax() {
        innerIntakeMotor = new CANSparkMax(Pins.CAN.kInnerIntakeMotor, MotorType.kBrushless);

        innerIntakeMotor.restoreFactoryDefaults();
        innerIntakeMotor.setInverted(true);
        innerIntakeMotor.setIdleMode(IdleMode.kBrake);
        innerIntakeMotor.setSmartCurrentLimit(35);

        intakeArmsMotor = new CANSparkMax(Pins.CAN.kIntakeMotor, MotorType.kBrushless);

        intakeSwitch = new DigitalInput(Pins.DIO.kIntakeSwitch);
        intakeArmsMotor.restoreFactoryDefaults();
        intakeArmsMotor.setInverted(true);
        intakeArmsMotor.setSmartCurrentLimit(35);
        // DoubleSolenoid test = new DoubleSolenoid(Pins.PCM.kPneumaticsModuleType,0,0);
        // //TODO: Switch to double??
        intakeArmsVirtualSolenoidA = new Solenoid(Pins.PCM.kPneumaticsModuleType, Pins.PCM.kIntakeArmA);
        intakeArmsVirtualSolenoidB = new Solenoid(Pins.PCM.kPneumaticsModuleType, Pins.PCM.kIntakeArmB);

        intakeArmsVirtualSolenoidA.set(false);
        intakeArmsVirtualSolenoidB.set(false);
    }

    @Override
    public void updateHardwareOutputs(IntakeHardwareOutputs outputs) {

        outputs.intakeSwitch = intakeSwitch.get();

        outputs.innerIntakeAppliedDutyCycle = innerIntakeMotor.getAppliedOutput();
        outputs.innerIntakeVelocityRPM = innerIntakeMotor.getEncoder().getVelocity();

        outputs.intakeAppliedDutyCycle = intakeArmsMotor.getAppliedOutput();
        outputs.intakeVelocityRPM = intakeArmsMotor.getEncoder().getVelocity();

        outputs.currentAmps = new double[] { intakeArmsMotor.getOutputCurrent(), innerIntakeMotor.getOutputCurrent() };
        outputs.tempCelcius = new double[] { intakeArmsMotor.getMotorTemperature(),
                innerIntakeMotor.getMotorTemperature() };

    }

    @Override
    public void extendIntake() {
        intakeArmsVirtualSolenoidA.set(true);
        intakeArmsVirtualSolenoidB.set(true);

    }

    @Override
    public void retractIntake() {
        intakeArmsVirtualSolenoidA.set(false);
        intakeArmsVirtualSolenoidB.set(false);

    }

    @Override
    public void floatIntake() {
        intakeArmsVirtualSolenoidA.set(false);
        intakeArmsVirtualSolenoidB.set(true);    

    }

    @Override
    public void setIntakeMotor(double speed) {
        intakeArmsMotor.set(speed);

    }

    @Override
    public void setInnerIntakeMotor(double speed) {
        innerIntakeMotor.set(speed);
    }

}
