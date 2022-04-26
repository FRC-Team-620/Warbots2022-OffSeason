package org.jmhsrobotics.offseason2022.commands.drivetrain;

import org.jmhsrobotics.core.subsystems.IDrivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenLoopDrive extends CommandBase {
    private IDrivetrain drivetrain;

    public OpenLoopDrive(IDrivetrain drivetrain) {
        this.drivetrain = drivetrain;
    }

    @Override
    public void execute() {
        drivetrain.controlVolts(0, 0);
    }

}
