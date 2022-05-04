package org.jmhsrobotics.offseason2022.subsystems.firingPins;

import org.jmhsrobotics.offseason2022.subsystems.firingPins.FiringPinsIO.FiringPinsHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FiringPins extends SubsystemBase {

    private FiringPinsIO io;
    private FiringPinsHardwareOutputs outputs;
    public FiringPins(FiringPinsIO io){
        this.io = io;
        this.outputs = new FiringPinsHardwareOutputs();
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("FiringPins", outputs);
    }
}
