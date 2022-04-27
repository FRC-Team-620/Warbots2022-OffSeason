package org.jmhsrobotics.offseason2022.controls;

import edu.wpi.first.wpilibj.XboxController;

public class SingleXboxControlBoard implements IControlBoard{
    private XboxController mControler;
    public SingleXboxControlBoard(){
        mControler = new XboxController(0);
    }

    @Override
    public boolean isIntake() {
        return mControler.getAButton();
    }

    @Override
    public double getForwardSpeed() {
        return -mControler.getLeftY();
    }

    @Override
    public double getDriveRotation() {
        return mControler.getLeftX();
    }
    
}
