package org.jmhsrobotics.offseason2022.subsystems.winch;

import org.jmhsrobotics.offseason2022.subsystems.winch.WinchIO.WinchHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Winch extends SubsystemBase {
    private WinchIO io;
    private WinchHardwareOutputs outputs;

    public Winch(WinchIO io) {
        this.io = io;
        this.outputs = new WinchHardwareOutputs();
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("Winch", outputs);
    }

    public void set(double speed) {
        io.set(speed);
    }

    public double getRotationRot() {
        return outputs.positionRot;
    }

    public boolean getClimberSensor() {
        return outputs.climberSensor;
    }

    public boolean atRearLimit() {
        return outputs.atRearLimit;
    }

    public void setEncoderPostion(double rotations) {
        io.setEncoderPostion(rotations);
    }

}
