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
        // DoubleSolenoid test = new DoubleSolenoid(Pins.PCM.kPneumaticsModuleType,0,0); //TODO: Switch to double??
        intakeArmsVirtualSolenoidA = new Solenoid(Pins.PCM.kPneumaticsModuleType, Pins.PCM.kIntakeArmA);
        intakeArmsVirtualSolenoidB = new Solenoid(Pins.PCM.kPneumaticsModuleType, Pins.PCM.kIntakeArmB);

        intakeArmsVirtualSolenoidA.set(false);
        intakeArmsVirtualSolenoidB.set(false);
    }

    @Override
    public void updateHardwareOutputs(IntakeHardwareOutputs outputs) {

        outputs.innerIntakeRPM = innerIntakeMotor.getEncoder().getVelocity();
        outputs.intakeRPM = intakeArmsMotor.getEncoder().getVelocity();
        outputs.intakeSwitch = intakeSwitch.get();

    }

    @Override
    public void extendIntake() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void retractIntake() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void floatIntake() {
        // TODO Auto-generated method stub
        
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
