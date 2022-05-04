package org.jmhsrobotics.offseason2022.subsystems.turret;

import org.jmhsrobotics.offseason2022.subsystems.turret.TurretIO.TurretHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private TurretIO io;
    private TurretHardwareOutputs outputs;
    public Turret(TurretIO io) {
        this.io = io;
        this.outputs = new TurretHardwareOutputs();
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("Turret", outputs);
    }

}
