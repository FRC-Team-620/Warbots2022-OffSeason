package org.jmhsrobotics.offseason2022.subsystems.winch;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxLimitSwitch;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxLimitSwitch.Type;

import org.jmhsrobotics.offseason2022.Pins;

import edu.wpi.first.wpilibj.DigitalInput;

public class WinchIOSparkMax implements WinchIO {

    private CANSparkMax leftClimberMotor, rightClimberMotor;
    private DigitalInput climberSensor; // TODO: Name to somthing better
    private SparkMaxLimitSwitch rearLimit;

    public WinchIOSparkMax() {
        leftClimberMotor = new CANSparkMax(Pins.CAN.kLeftClimberMotor, MotorType.kBrushless);
        rightClimberMotor = new CANSparkMax(Pins.CAN.kRightClimberMotor, MotorType.kBrushless);
        climberSensor = new DigitalInput(Pins.DIO.kClimberSensor);
        rearLimit = leftClimberMotor.getReverseLimitSwitch(Type.kNormallyClosed);

        leftClimberMotor.restoreFactoryDefaults();
        rightClimberMotor.restoreFactoryDefaults();

        IdleMode mode = IdleMode.kBrake;
        leftClimberMotor.setIdleMode(mode);
        rightClimberMotor.setIdleMode(mode);

        rightClimberMotor.follow(leftClimberMotor, true);
    }

    @Override
    public void updateHardwareOutputs(WinchHardwareOutputs outputs) {
        outputs.atRearLimit = rearLimit.isPressed();
        outputs.climberSensor = climberSensor.get();
        outputs.positionRot = leftClimberMotor.getEncoder().getPosition();

        outputs.velocityRPM = leftClimberMotor.getEncoder().getVelocity();
        outputs.appliedDutyCycle = leftClimberMotor.getAppliedOutput();
        outputs.currentAmps = new double[] {rightClimberMotor.getOutputCurrent(), leftClimberMotor.getOutputCurrent()};
        outputs.tempCelcius = new double[] { rightClimberMotor.getMotorTemperature(),leftClimberMotor.getMotorTemperature() };

    }

    @Override
    public void set(double speed) {
        leftClimberMotor.set(speed);
    }

    @Override
    public void setEncoderPostion(double rotations) {
       leftClimberMotor.getEncoder().setPosition(rotations);
       rightClimberMotor.getEncoder().setPosition(rotations);
        
    }

}
