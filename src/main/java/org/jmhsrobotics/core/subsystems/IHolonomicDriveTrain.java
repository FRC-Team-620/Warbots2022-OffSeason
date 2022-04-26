package org.jmhsrobotics.core.subsystems;

public interface IHolonomicDriveTrain extends IDrivetrain{
    public void controlVolts(double forward,double latteral,double rotate); //TODO: example framework pick better class names
    public void controlVelocity(double forward,double latteral, double rotation);
    
}
