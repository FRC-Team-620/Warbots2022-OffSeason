package org.jmhsrobotics.core.subsystems;

public interface IDrivetrain {
    public void controlVolts(double forward,double rotate);
    public void controlVelocity(double forward, double rotation);
}
