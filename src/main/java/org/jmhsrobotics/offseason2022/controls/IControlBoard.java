package org.jmhsrobotics.offseason2022.controls;

public interface IControlBoard {
    public boolean isIntake();
    public double getForwardSpeed();//TODO refactor names here
    public double getDriveRotation();
    
}
