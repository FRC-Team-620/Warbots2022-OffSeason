package org.jmhsrobotics.offseason2022.subsystems.turret;

import org.jmhsrobotics.offseason2022.subsystems.turret.TurretIO.TurretHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Turret extends SubsystemBase {
    private TurretIO io;
    private TurretHardwareOutputs outputs;

    public Turret(TurretIO io) {
        this.io = io;
        this.outputs = new TurretHardwareOutputs();

        io.setPID(0, 0, 0); // TODO: put real pid values

    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("Turret", outputs);

    }

    public void setGoal(Rotation2d rot) {
        // TODO: Set goal and speed in trapzoidal motion profile
    }

    public void set(double speed) {
        // Open loop control
        io.set(speed);
    }

    public void setBrakeMode(boolean enable) {
        io.setBrakeMode(enable);
    }

    public boolean atGoal() {
        // returns if turret is at goal within torlorance
        // TODO implmenet
        return false;
    }

    public Rotation2d getRotation2d() {
        return Rotation2d.fromDegrees(outputs.rotationDegrees);
    }

}
