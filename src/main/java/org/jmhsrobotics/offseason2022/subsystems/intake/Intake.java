package org.jmhsrobotics.offseason2022.subsystems.intake;

import org.jmhsrobotics.offseason2022.Constants;
import org.jmhsrobotics.offseason2022.subsystems.intake.IntakeIO.IntakeHardwareOutputs;
import org.littletonrobotics.junction.Logger;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
    private IntakeIO io;
    private IntakeHardwareOutputs outputs;
    private Debouncer debounce;
    private boolean balldetected = false;

    public Intake(IntakeIO io) {
        this.io = io;
        this.outputs = new IntakeHardwareOutputs();
        debounce = new Debouncer(Constants.kIntakeSwitchDebounceTime);
    }

    @Override
    public void periodic() {
        io.updateHardwareOutputs(outputs);
        Logger.getInstance().processInputs("Intake", outputs);
        balldetected = debounce.calculate(outputs.intakeSwitch);

    }

    public void extend() {
        io.extendIntake();
    }
    public void retract(){
        io.retractIntake();
    }
    public void floatIntake(){ //TODO: Better naming
        io.floatIntake();
    }
    public boolean isBallDetected(){
        return balldetected;
    }

}
