package org.jmhsrobotics.offseason2022.controls;

public class ControlMap  {
    private static IControlBoard controls = new SingleXboxControlBoard(); //Default ControlBoard
    public static IControlBoard getControlBoard(){//TODO: Should I make this a Singleton?
        return controls;
    }
    public static void setControlBoard(IControlBoard controls){
        ControlMap.controls = controls;
    }
}
