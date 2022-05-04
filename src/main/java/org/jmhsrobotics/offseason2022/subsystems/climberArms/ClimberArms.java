package org.jmhsrobotics.offseason2022.subsystems.climberArms;

import org.jmhsrobotics.offseason2022.subsystems.climberArms.ClimberArmsIO.ClimberArmsHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberArms extends SubsystemBase {
    private ClimberArmsIO io;
    private ClimberArmsHardwareOutputs outputs;

    public ClimberArms(ClimberArmsIO io) {
        this.io = io;
        this.outputs = new ClimberArmsHardwareOutputs();
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("CLimberArms", outputs);
    }

}
