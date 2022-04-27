package org.jmhsrobotics.core.subsystems;

import edu.wpi.first.wpilibj2.command.Subsystem;

public interface IDrivetrain extends Subsystem {
    public void controlVolts(double forward, double rotate);

    public void controlVelocity(double forward, double rotation);
}
