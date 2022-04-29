package org.jmhsrobotics.offseason2022.commands.drivetrain;

import org.jmhsrobotics.offseason2022.controls.ControlMap;
import org.jmhsrobotics.offseason2022.subsystems.drivetrain.Drivetrain;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class OpenLoopDrive extends CommandBase {
    private Drivetrain drivetrain;

    public OpenLoopDrive(Drivetrain drivetrain) {
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
    }

    @Override
    public void execute() {
        drivetrain.arcadeDrive(ControlMap.getControlBoard().getForwardSpeed(), ControlMap.getControlBoard().getDriveRotation());
    }

}
