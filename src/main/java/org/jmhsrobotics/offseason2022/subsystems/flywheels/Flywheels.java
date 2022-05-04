package org.jmhsrobotics.offseason2022.subsystems.flywheels;

import org.jmhsrobotics.offseason2022.subsystems.flywheels.FlywheelsIO.FlywheelsHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Flywheels extends SubsystemBase {
    private FlywheelsIO io;
    private FlywheelsHardwareOutputs outputs;
    public Flywheels(FlywheelsIO io) {
        this.io = io;
        this.outputs = new FlywheelsHardwareOutputs();
    }
    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("Flywheels", outputs);
    }

    public void setRPM(double rpm){

    }
    public boolean atSetpoint(){
        // TODO Auto-generated method stub
        return false;
    }

}
