package org.jmhsrobotics.offseason2022.commands.drivetrain;

import org.jmhsrobotics.core.subsystems.IDrivetrain;
import org.jmhsrobotics.offseason2022.controls.SingleXboxControlBoard;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenLoopDrive extends CommandBase {
    private IDrivetrain drivetrain;
    private SingleXboxControlBoard cb;

    public OpenLoopDrive(IDrivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
        cb = new SingleXboxControlBoard();
    }

    @Override
    public void execute() {
        drivetrain.controlVolts(cb.getForwardSpeed()*12, cb.getDriveRotation()*12);
    }

}
